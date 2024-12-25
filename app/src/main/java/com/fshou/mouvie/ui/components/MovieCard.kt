package com.fshou.mouvie.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fshou.mouvie.ui.theme.MouvieTheme
import com.fshou.mouvie.ui.utils.borderGradientBrush


@Composable
fun MovieCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(200.dp)
            .width(170.dp)
            .clip(MaterialTheme.shapes.small)
            .background(
                color = Color(0xFF050505), shape = MaterialTheme.shapes.small
            )
            .border(
                width = 1.dp, brush = borderGradientBrush, shape = MaterialTheme.shapes.small
            ), contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.fillMaxSize())  // TODO:Replace with img
    }
}

@Preview
@Composable
private fun MovieCardPrev() {
    MouvieTheme {
        MovieCard()
    }
}