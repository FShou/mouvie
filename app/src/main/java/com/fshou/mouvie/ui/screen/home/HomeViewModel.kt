package com.fshou.mouvie.ui.screen.home

import androidx.lifecycle.ViewModel
import com.fshou.mouvie.data.MovieRepository

class HomeViewModel(movieRepository: MovieRepository): ViewModel() {
     val previewDiscoverMovies = movieRepository.getPreviewDiscoverMovies()
     val previewNowPlayingMovies = movieRepository.getPreviewNowPlayingMovies()
     val previewUpcomingMovies = movieRepository.getPreviewUpcomingMovies()
     val previewPopularMovies = movieRepository.getPreviewPopularMovies()
     val previewTopRatedMovies = movieRepository.getPreviewTopRatedMovies()
}