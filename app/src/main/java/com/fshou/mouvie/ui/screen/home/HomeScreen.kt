package com.fshou.mouvie.ui.screen.home

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fshou.mouvie.data.utils.RequestState
import com.fshou.mouvie.ui.components.MovieListSection
import com.fshou.mouvie.ui.components.PageTitle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit,
    navigateToAbout: (Unit) -> Unit,
    scrollState: ScrollState = rememberScrollState(),
    viewModel: HomeViewModel = koinViewModel()
) {
    val discoverMovies by viewModel.previewDiscoverMovies.collectAsStateWithLifecycle()
    val nowPlayingMovies by viewModel.previewNowPlayingMovies.collectAsStateWithLifecycle()
    val upcomingMovies by viewModel.previewUpcomingMovies.collectAsStateWithLifecycle()
    val popularMovies by viewModel.previewPopularMovies.collectAsStateWithLifecycle()
    val topRatedMovies by viewModel.previewTopRatedMovies.collectAsStateWithLifecycle()


    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        PageTitle(text = "Home")
        MovieListSection(
            navigateToDetail = navigateToDetail,
            title = "Discover",
            movieListResponseUiState = discoverMovies,
        )
        Spacer(modifier = Modifier.height(24.dp))

        MovieListSection(
            navigateToDetail = navigateToDetail,
            title = "Now Playing",
            movieListResponseUiState = nowPlayingMovies
        )
        Spacer(modifier = Modifier.height(24.dp))

        MovieListSection(
            navigateToDetail = navigateToDetail,
            title = "Upcoming",
            movieListResponseUiState = upcomingMovies
        )
        Spacer(modifier = Modifier.height(24.dp))
        MovieListSection(
            navigateToDetail = navigateToDetail,
            title = "Popular",
            movieListResponseUiState = popularMovies
        )
        Spacer(modifier = Modifier.height(24.dp))

        MovieListSection(
            navigateToDetail = navigateToDetail,
            title = "Top Rated",
            movieListResponseUiState = topRatedMovies
        )
        Spacer(modifier = Modifier.height(24.dp))

    }
}