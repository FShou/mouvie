package com.fshou.mouvie.data

import com.fshou.mouvie.data.network.service.TMDBService
import kotlinx.coroutines.flow.flow

class MovieRepository(
    private val TMDBService: TMDBService
) {
    fun getMovieDetail(movieId: Int) = flow { emit(TMDBService.getMovieDetail(movieId)) }

    fun getPreviewDiscoverMovies() = flow { emit(TMDBService.getDiscoverMovies()) }
    fun getAllDiscoverMovies() {
        // TODO: All
    }


    fun getPreviewNowPlayingMovies() = flow { emit(TMDBService.getNowPlayingMovies()) }
    fun getAllNowPlayingMovies() {
        // TODO: All
    }

    fun getPreviewUpcomingMovies() = flow { emit(TMDBService.getUpcomingMovies()) }
    fun getAllUpcomingMovies() {
        // TODO: All
    }

    fun getPreviewPopularMovies() = flow { emit(TMDBService.getPopularMovies()) }
    fun getAllPopularMovies() {
        // TODO: All
    }

    fun getPreviewTopRatedMovies() = flow { emit(TMDBService.getTopRatedMovies()) }
    fun getAllTopRatedMovies() {
        // TODO: All
    }

}