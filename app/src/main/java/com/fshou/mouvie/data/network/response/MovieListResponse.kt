package com.fshou.mouvie.data.network.response

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("results")
    val results: List<ResultsItem>? = null,
)

data class ResultsItem(

    @field:SerializedName("title")
    val title: String,


    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("backdrop_path")
    val backdropPath: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("id")
    val id: Int,
)
