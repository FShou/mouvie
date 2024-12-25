package com.fshou.mouvie.data.network.service

import com.fshou.mouvie.data.network.response.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("/discover/movie")
    suspend fun getDiscoverMovies(
        @Query("include_adult")
        includeAdult: Boolean = false,

        @Query("include_video")
        includeVideo: Boolean = false,

        @Query("language")
        language: String = "en-US",

        @Query("page")
        page: Int = 1,

        @Query("sort_by")
        sortBy: String = "popularity.desc"
    ): MovieListResponse

    @GET("/movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("language")
        language: String = "en-US",

        @Query("region")
        region: String = "US",

        @Query("page")
        page: Int = 1,
    ): MovieListResponse

    @GET("/movie/popular")
    suspend fun getPopularMovies(
        @Query("language")
        language: String = "en-US",

        @Query("region")
        region: String = "US",

        @Query("page")
        page: Int = 1,
    ): MovieListResponse


    @GET("/movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("language")
        language: String = "en-US",

        @Query("region")
        region: String = "US",

        @Query("page")
        page: Int = 1,
    ): MovieListResponse

    @GET("/movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("language")
        language: String = "en-US",

        @Query("region")
        region: String = "US",

        @Query("page")
        page: Int = 1,
    ): MovieListResponse

}