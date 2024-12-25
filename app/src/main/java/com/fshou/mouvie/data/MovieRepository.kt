package com.fshou.mouvie.data

import com.fshou.mouvie.data.network.service.TMDBService
import com.fshou.mouvie.data.utils.BaseRepository

class MovieRepository(
    private val TMDBService: TMDBService
) : BaseRepository() {
    fun getPreviewDiscoverMovies() = callApiWithState { TMDBService.getDiscoverMovies() }

    fun getAllDiscoverMovies() {
        // TODO: All
    }


    fun getPreviewNowPlayingMovies() = callApiWithState { TMDBService.getNowPlayingMovies() }

    fun getAllNowPlayingMovies() {
        // TODO: All
    }

    fun getPreviewUpcomingMovies() = callApiWithState { TMDBService.getUpcomingMovies() }
    fun getAllUpcomingMovies() {
        // TODO: All
    }

    fun getPreviewPopularMovies() = callApiWithState { TMDBService.getPopularMovies() }

    fun getAllPopularMovies() {
        // TODO: All
    }

    fun getPreviewTopRatedMovies() = callApiWithState { TMDBService.getTopRatedMovies() }

    fun getAllTopRatedMovies() {
        // TODO: All
    }
    
}