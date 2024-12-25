package com.fshou.mouvie.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fshou.mouvie.data.network.response.MovieItem
import com.fshou.mouvie.ui.theme.MouvieTheme

@Composable
fun SectionTitle(modifier: Modifier = Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleLarge,
        color = Color.White
    )
}

@Preview
@Composable
private fun SectionTitlePrev() {
    MouvieTheme {

        SectionTitle(text = "Now Playing")

    }
}

@Composable
fun MovieCardList(
    modifier: Modifier = Modifier,
    movieList: List<MovieItem> = emptyList(),
    navigateToDetail: (Int) -> Unit,
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
        ,
        contentPadding = PaddingValues(horizontal = 24.dp)
    ) {
        items(movieList) { movieItem ->
            MovieCard(
                movieId = movieItem.id,
                posterPath = movieItem.posterPath,
                onClick = navigateToDetail
            )
        }
    }
}

val DUMMY_MOVIE_LIST = List(10) {
    MovieItem(
        id = it,
        title = "Sample",
        releaseDate = "",
        backdropPath = "",
        posterPath = ""
    )
}

@Preview
@Composable
private fun MovieCardListPrev() {
    MovieCardList(
        movieList = DUMMY_MOVIE_LIST,
        navigateToDetail = {}
    )
}

@Composable
fun MovieListSection(
    modifier: Modifier = Modifier,
    movieList: List<MovieItem> = emptyList(),
    navigateToDetail: (Int) -> Unit,
    title: String
) {
    Column(modifier = modifier) {
        SectionTitle(text = title, modifier = Modifier.padding(horizontal = 24.dp))
        Spacer(modifier = Modifier.height(12.dp))
        MovieCardList(
            movieList = movieList,
            navigateToDetail = navigateToDetail,
        )
    }
}

@Preview
@Composable
private fun MovieListSectionPrev() {
    MovieListSection(
        navigateToDetail = {},
        title = "Now Playing",
        movieList = DUMMY_MOVIE_LIST,
    )
}