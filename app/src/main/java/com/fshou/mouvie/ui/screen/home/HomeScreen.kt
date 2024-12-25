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
import com.fshou.mouvie.utils.REGION
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


    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        MovieListSection(
            navigateToDetail = navigateToDetail,
            title = "Discover",
            requestState = discoverMovies.value,
        )
        Spacer(modifier = Modifier.height(24.dp))

        MovieListSection(
            navigateToDetail = navigateToDetail,
            title = "Now Playing",
            requestState = nowPlayingMovies.value
        )
        Spacer(modifier = Modifier.height(24.dp))

        MovieListSection(
            navigateToDetail = navigateToDetail,
            title = "Upcoming",
            requestState = upcomingMovies.value
        )
        Spacer(modifier = Modifier.height(24.dp))
        MovieListSection(
            navigateToDetail = navigateToDetail,
            title = "Popular",
            requestState = popularMovies.value
        )
        Spacer(modifier = Modifier.height(24.dp))

        MovieListSection(
            navigateToDetail = navigateToDetail,
            title = "Top Rated",
            requestState = topRatedMovies.value
        )
        Spacer(modifier = Modifier.height(24.dp))

    }
}