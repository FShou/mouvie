package com.fshou.mouvie.data.utils

import com.fshou.mouvie.data.network.response.ErrorResponse
import com.fshou.mouvie.ui.utils.UiState
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.retryWhen
import kotlinx.coroutines.flow.stateIn
import retrofit2.HttpException
import java.io.IOException

private const val RETRY_TIME_IN_MILLIS = 15_000L
private const val RETRY_ATTEMPT_COUNT = 3

sealed interface RequestState<out R> {
    data class Success<out T>(val data: T) : RequestState<T>
    data object Loading : RequestState<Nothing>
    data class Error(val msg: String) : RequestState<Nothing>
}

fun <T> Flow<T>.asRequestState(): Flow<RequestState<T>> {
    return this
        .map<T, RequestState<T>> {
            RequestState.Success(it)
        }
        .flowOn(Dispatchers.IO)
        .onStart { emit(RequestState.Loading) }
        .retryWhen { cause, attempt ->
            if (cause is IOException && attempt < RETRY_ATTEMPT_COUNT) {
                delay(RETRY_TIME_IN_MILLIS)
                true
            } else {
                false
            }
        }
        .catch { cause ->
            if (cause is HttpException) {
                val jsonBody = cause.response()?.errorBody()?.string()
                val errorBody = Gson().fromJson(jsonBody, ErrorResponse::class.java)
                errorBody?.let {
                    emit(RequestState.Error(it.statusMessage))
                }
            } else {
                emit(RequestState.Error(cause.message ?: "Error with no message"))
            }
        }
}

const val DEFAULT_TIMEOUT = 10000L
fun <T> Flow<RequestState<T>>.uiStateStateFlow(scope: CoroutineScope): StateFlow<UiState<T>> {
    return this.map {
        when (it) {
            is RequestState.Error -> UiState.Error(msg = it.msg)
            RequestState.Loading -> UiState.Loading
            is RequestState.Success -> UiState.Success(it.data)
        }
    }
        .stateIn(
            scope = scope,
            initialValue = UiState.Loading,
            started = SharingStarted.WhileSubscribed(DEFAULT_TIMEOUT)
        )
}