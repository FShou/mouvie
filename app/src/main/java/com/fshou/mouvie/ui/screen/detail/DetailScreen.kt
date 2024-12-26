package com.fshou.mouvie.ui.screen.detail

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.fshou.mouvie.data.network.response.MovieDetailResponse
import com.fshou.mouvie.ui.components.MovieCard
import com.fshou.mouvie.ui.utils.UiState
import com.fshou.mouvie.utils.IMAGE_BASE_URL
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    movieId: Int,
    viewModel: DetailViewModel = koinViewModel()
) {
    val movieDetail by viewModel.movieDetail.collectAsState(initial = UiState.Loading)
    when (movieDetail) {
        is UiState.Error -> {

        }

        UiState.Loading -> {
            DetailScreenLoading()
            viewModel.loadMovieDetail(movieId)
        }

        is UiState.Success -> {
            val movie = (movieDetail as UiState.Success<MovieDetailResponse>).data
            DetailScreen(movie = movie)
        }
    }
}

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    movie: MovieDetailResponse,
    scrollState: ScrollState = rememberScrollState()
) {
    Column(
        modifier
            .fillMaxWidth()

    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("$IMAGE_BASE_URL/w780${movie.backdropPath}")
                .crossfade(true)
                .build(),
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.FillBounds,
            contentDescription = null

        )
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            Modifier
                .padding(horizontal = 24.dp)
                .verticalScroll(scrollState)
        ) {
            Text(text = movie.title, style = MaterialTheme.typography.titleLarge)
            Text(text = movie.tagline, color = Color(0xaaffffff))
            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Overview", style = MaterialTheme.typography.titleLarge)
            Text(text = movie.overview, color = Color(0xaaffffff), textAlign = TextAlign.Justify)
            Spacer(modifier = Modifier.height(36.dp))
        }

    }
}

@Composable
fun DetailScreenLoading(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .fillMaxWidth()

    ) {
        Skeleton(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
        )
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            Modifier
                .padding(horizontal = 24.dp)

        ) {
            Skeleton(Modifier.height(38.dp).fillMaxWidth())
            Spacer(modifier = Modifier.height(8.dp))

            Skeleton(Modifier.height(16.dp).fillMaxWidth())
            Spacer(modifier = Modifier.height(24.dp))

            Skeleton(Modifier.height(38.dp).fillMaxWidth())
            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn {
                items(5) {
                    Skeleton(Modifier.height(16.dp).fillMaxWidth())
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
            Spacer(modifier = Modifier.height(36.dp))
        }

    }
}

@Composable
fun Skeleton(modifier: Modifier = Modifier) {
    Box(
        modifier
            .clip(MaterialTheme.shapes.medium)
            .background(shape = MaterialTheme.shapes.medium, color = Color(0xff4f4f4f))
            .shimmer()
    )
}

@Composable
fun Modifier.shimmer(
    duration: Int = 1200, // Duration for shimmer animation
): Modifier {
    val infiniteTransition = rememberInfiniteTransition(label = "shimmer")

    // Animating the shimmer effect horizontally
    val translationX by infiniteTransition.animateFloat(
        initialValue = -1000f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = duration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = "shimmers"
    )

    // Create a shimmer brush with dynamic opacity for the background color
    val shimmerBrush = Brush.linearGradient(
        colors = listOf(
            Color.Gray.copy(alpha = 0.2f),  // Light version of the background
            Color.Gray.copy(alpha = 0.5f),  // Medium version of the background (highlight)
            Color.Gray.copy(alpha = 0.2f)   // Light version again
        ),
        start = Offset(0f, 0f),
        end = Offset(1000f, 0f)  // Move from left to right
    )

    return this
        .background(shimmerBrush) // Apply shimmer effect on top of the existing background color
        .graphicsLayer(translationX = translationX) // Animate the shimmer translation
}

@Preview
@Composable
private fun DetailScreenPrev() {
//    DetailScreen(movie = MovieDetailResponse())
}