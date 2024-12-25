package com.fshou.mouvie.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit,
    navigateToAbout: (Unit) -> Unit,
    viewModel: HomeViewModel = koinViewModel()
) {
    Text(text = "HOME", modifier = modifier.clickable {
        navigateToDetail(1)
    })
}