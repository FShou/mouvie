package com.fshou.mouvie.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fshou.mouvie.data.MovieRepository
import com.fshou.mouvie.data.utils.asRequestState
import com.fshou.mouvie.data.utils.asUiState


class HomeViewModel(movieRepository: MovieRepository) : ViewModel() {
    val previewDiscoverMovies =
        movieRepository.getPreviewDiscoverMovies().asRequestState().asUiState(viewModelScope)
    val previewNowPlayingMovies =
        movieRepository.getPreviewNowPlayingMovies().asRequestState().asUiState(viewModelScope)
    val previewUpcomingMovies =
        movieRepository.getPreviewUpcomingMovies().asRequestState().asUiState(viewModelScope)
    val previewPopularMovies =
        movieRepository.getPreviewPopularMovies().asRequestState().asUiState(viewModelScope)
    val previewTopRatedMovies =
        movieRepository.getPreviewTopRatedMovies().asRequestState().asUiState(viewModelScope)
}

