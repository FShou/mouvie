package com.fshou.mouvie.data.network.service

import com.fshou.mouvie.data.network.response.MovieDetailResponse
import com.fshou.mouvie.data.network.response.MovieListResponse
import com.fshou.mouvie.utils.API_KEY
import com.fshou.mouvie.utils.REGION
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/{movieId}")
     suspend fun getMovieDetail(
        @Path("movieId")
        movieId: Int,
        @Query("api_key")
        apiKey: String= API_KEY
    ): MovieDetailResponse

    @GET("discover/movie")
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
        sortBy: String = "popularity.desc",
        @Query("api_key")
        apiKey: String= API_KEY
    ): MovieListResponse

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("language")
        language: String = "en-US",

        @Query("region")
        region: String = REGION,

        @Query("page")
        page: Int = 1,
        @Query("api_key")
        apiKey: String= API_KEY
    ): MovieListResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language")
        language: String = "en-US",

        @Query("region")
        region: String = REGION,

        @Query("page")
        page: Int = 1,
        @Query("api_key")
        apiKey: String= API_KEY
    ): MovieListResponse


    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("language")
        language: String = "en-US",

        @Query("region")
        region: String = REGION,

        @Query("page")
        page: Int = 1,
        @Query("api_key")
        apiKey: String= API_KEY
    ): MovieListResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("language")
        language: String = "en-US",

        @Query("region")
        region: String = REGION,

        @Query("page")
        page: Int = 1,

        @Query("api_key")
        apiKey: String= API_KEY
    ): MovieListResponse

}