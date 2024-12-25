package com.fshou.mouvie.data.utils

import android.util.Log
import com.fshou.mouvie.data.network.response.ErrorResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException

abstract class BaseRepository {
    protected inline fun <T> callApiWithState(crossinline apiCall: suspend () -> T) = flow<RequestState<T>> {
        emit(RequestState.Loading)
        try {
            val response = apiCall()
            emit(RequestState.Success(response))
        } catch (e: HttpException) {
            val jsonBody = e.response()?.errorBody()?.string()
            val errorBody = Gson().fromJson(jsonBody, ErrorResponse::class.java)
            errorBody?.let {
                emit(RequestState.Error(it.statusMessage))
            }
        }
        catch (e: Exception) {
            Log.e("REPO", e.toString())
            e.message
                ?.let { RequestState.Error(it) }
                ?.let {
                    emit(it)
                }
        }
    }.flowOn(Dispatchers.IO)
}

