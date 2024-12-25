package com.fshou.mouvie.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.fshou.mouvie.di.networkModule
import com.fshou.mouvie.di.repositoryModule
import com.fshou.mouvie.ui.components.MovieCard
import com.fshou.mouvie.ui.theme.MouvieTheme
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(application = {
        modules(
            networkModule,
            repositoryModule
        ) // Todo
    }) {
        MouvieTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Box(modifier = Modifier.fillMaxSize().padding(innerPadding).background(color = Color(0xFF020202)), contentAlignment = Alignment.Center){
                    MovieCard()
                }
            }
        }
    }
}