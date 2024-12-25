package com.fshou.mouvie.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fshou.mouvie.data.MovieRepository
import com.fshou.mouvie.data.utils.asRequestState
import com.fshou.mouvie.data.utils.uiStateStateFlow


class HomeViewModel(movieRepository: MovieRepository) : ViewModel() {
    val previewDiscoverMovies =
        movieRepository
            .getPreviewDiscoverMovies()
            .asRequestState()
            .uiStateStateFlow(viewModelScope)
    val previewNowPlayingMovies =
        movieRepository
            .getPreviewNowPlayingMovies()
            .asRequestState()
            .uiStateStateFlow(viewModelScope)
    val previewUpcomingMovies =
        movieRepository
            .getPreviewUpcomingMovies()
            .asRequestState()
            .uiStateStateFlow(viewModelScope)
    val previewPopularMovies =
        movieRepository
            .getPreviewPopularMovies()
            .asRequestState()
            .uiStateStateFlow(viewModelScope)
    val previewTopRatedMovies =
        movieRepository
            .getPreviewTopRatedMovies()
            .asRequestState()
            .uiStateStateFlow(viewModelScope)
}

