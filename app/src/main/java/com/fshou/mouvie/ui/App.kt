package com.fshou.mouvie.ui


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.fshou.mouvie.di.networkModule
import com.fshou.mouvie.di.repositoryModule
import com.fshou.mouvie.di.viewModelModule
import com.fshou.mouvie.ui.navigation.Screen
import com.fshou.mouvie.ui.screen.about.AboutScreen
import com.fshou.mouvie.ui.screen.detail.DetailScreen
import com.fshou.mouvie.ui.screen.home.HomeScreen
import com.fshou.mouvie.ui.theme.MouvieTheme
import org.koin.compose.KoinApplication

@Composable
fun App(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    KoinApplication(application = {
        modules(
            networkModule, repositoryModule, viewModelModule
        )
    }) {
        MouvieTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route,
                    modifier = modifier.padding(innerPadding)
                ) {

                    composable(Screen.Home.route) {
                        HomeScreen(navigateToDetail = { movieId ->
                            navController.navigate(Screen.Detail.createRoute(movieId))
                        }, navigateToAbout = {
                            navController.navigate(Screen.About.route)

                        })
                    }

                    composable(Screen.About.route) {
                        AboutScreen()
                    }

                    composable(
                        route = Screen.Detail.route,
                        arguments = listOf(navArgument("movieId") { type = NavType.IntType })
                    ) {
                        val movieId = it.arguments?.getInt("movieId") ?: -1
                        DetailScreen(
                            movieId = movieId
                        )
                    }
                }
            }
        }
    }
}