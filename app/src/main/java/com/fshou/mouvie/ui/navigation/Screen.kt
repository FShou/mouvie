package com.fshou.mouvie.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")

    object Detail : Screen("home/{movieId}") {
        fun createRoute(movieId: Int) = "home/$movieId"
    }

    object About : Screen("about")
}