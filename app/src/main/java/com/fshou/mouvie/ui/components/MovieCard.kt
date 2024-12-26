package com.fshou.mouvie.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.fshou.mouvie.ui.theme.MouvieTheme
import com.fshou.mouvie.ui.utils.borderGradientBrush
import com.fshou.mouvie.utils.IMAGE_BASE_URL


@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    posterPath: String = "",
    movieId: Int = -1,
    onClick: (Int) -> Unit = {}
) {
    Box(
        modifier = modifier
            .height(200.dp)
            .width(130.dp)
            .clip(MaterialTheme.shapes.small)
            .background(color = Color(0xFF050505))
            .border(
                width = 2.dp,
                brush = borderGradientBrush,
                shape = MaterialTheme.shapes.small
            ).clickable {
                onClick(movieId)
            }
        ,
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data("$IMAGE_BASE_URL/w500$posterPath")
                .crossfade(true)
                .build(),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
        )
    }
}

@Preview
@Composable
private fun MovieCardPrev() {
    MouvieTheme {
        MovieCard() {

        }
    }
}