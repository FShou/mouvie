package com.fshou.mouvie.ui.screen.home

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.fshou.mouvie.data.network.response.MovieListResponse
import com.fshou.mouvie.data.utils.RequestState
import com.fshou.mouvie.ui.components.MovieListSection
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit,
    navigateToAbout: (Unit) -> Unit,
    scrollState: ScrollState = rememberScrollState(),
    viewModel: HomeViewModel = koinViewModel()
) {
    val discoverMovies =
        viewModel.previewDiscoverMovies.collectAsState(initial = RequestState.Loading)
    val nowPlayingMovies =
        viewModel.previewNowPlayingMovies.collectAsState(initial = RequestState.Loading)
    val upcomingMovies =
        viewModel.previewUpcomingMovies.collectAsState(initial = RequestState.Loading)
    val popularMovies =
        viewModel.previewPopularMovies.collectAsState(initial = RequestState.Loading)
    val topRatedMovies =
        viewModel.previewTopRatedMovies.collectAsState(initial = RequestState.Loading)

    Column(modifier = modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
    ) {
        when (discoverMovies.value) {
            is RequestState.Error -> {
                Text(text = (discoverMovies.value as RequestState.Error).msg, color = Color.White)
            }

            RequestState.Loading -> {
                Text(text = "Loading", color = Color.White)
            }

            is RequestState.Success -> {
                (discoverMovies.value as RequestState.Success<MovieListResponse>).data.results?.let {
                    MovieListSection(
                        navigateToDetail = navigateToDetail,
                        title = "Discover",
                        movieList = it
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        when (nowPlayingMovies.value) {
            is RequestState.Error -> {
                Text(text = (nowPlayingMovies.value as RequestState.Error).msg, color = Color.White)
            }

            RequestState.Loading -> {
                Text(text = "Loading", color = Color.White)
            }

            is RequestState.Success -> {
                (nowPlayingMovies.value as RequestState.Success<MovieListResponse>).data.results?.let {
                    MovieListSection(
                        navigateToDetail = navigateToDetail,
                        title = "Now Playing",
                        movieList = it
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        when (upcomingMovies.value) {
            is RequestState.Error -> {
                Text(text = (upcomingMovies.value as RequestState.Error).msg, color = Color.White)
            }

            RequestState.Loading -> {
                Text(text = "Loading", color = Color.White)
            }

            is RequestState.Success -> {
                (upcomingMovies.value as RequestState.Success<MovieListResponse>).data.results?.let {
                    MovieListSection(
                        navigateToDetail = navigateToDetail,
                        title = "Upcoming",
                        movieList = it
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        when (popularMovies.value) {
            is RequestState.Error -> {
                Text(text = (popularMovies.value as RequestState.Error).msg, color = Color.White)
            }

            RequestState.Loading -> {
                Text(text = "Loading", color = Color.White)
            }

            is RequestState.Success -> {
                (popularMovies.value as RequestState.Success<MovieListResponse>).data.results?.let {
                    MovieListSection(
                        navigateToDetail = navigateToDetail,
                        title = "Popular",
                        movieList = it
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(18.dp))
        when (topRatedMovies.value) {
            is RequestState.Error -> {
                Text(text = (topRatedMovies.value as RequestState.Error).msg, color = Color.White)
            }

            RequestState.Loading -> {
                Text(text = "Loading", color = Color.White)
            }

            is RequestState.Success -> {
                (topRatedMovies.value as RequestState.Success<MovieListResponse>).data.results?.let {
                    MovieListSection(
                        navigateToDetail = navigateToDetail,
                        title = "Top Rated",
                        movieList = it
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(18.dp))

    }
}