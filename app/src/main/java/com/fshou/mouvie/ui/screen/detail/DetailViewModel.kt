package com.fshou.mouvie.ui.screen.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fshou.mouvie.data.MovieRepository
import com.fshou.mouvie.data.network.response.MovieDetailResponse
import com.fshou.mouvie.data.utils.RequestState
import com.fshou.mouvie.data.utils.asRequestState
import com.fshou.mouvie.di.viewModelModule
import com.fshou.mouvie.ui.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DetailViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private val _movieDetail = MutableStateFlow<UiState<MovieDetailResponse>>(UiState.Loading)
    val movieDetail: StateFlow<UiState<MovieDetailResponse>> = _movieDetail

    fun loadMovieDetail(id: Int) {
        viewModelScope.launch {
            println("ViemModel: $id")
            movieRepository
                .getMovieDetail(id)
                .asRequestState()
                .collect { request ->
                Log.d("ViewMODEL", request.toString())
                _movieDetail.update {
                    when (request) {
                        is RequestState.Error -> UiState.Error(request.msg)
                        is RequestState.Loading -> UiState.Loading
                        is RequestState.Success -> UiState.Success(request.data)
                    }
                }
            }
        }
    }
}