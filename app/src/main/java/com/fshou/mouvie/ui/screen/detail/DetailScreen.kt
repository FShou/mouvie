package com.fshou.mouvie.ui.screen.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    movieId: Int,
    viewModel: DetailViewModel = koinViewModel()
) {
    Text(text = "DETAIL $movieId")
}