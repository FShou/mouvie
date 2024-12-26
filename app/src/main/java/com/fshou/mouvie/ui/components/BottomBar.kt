package com.fshou.mouvie.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.fshou.mouvie.ui.navigation.NavigationItem
import com.fshou.mouvie.ui.navigation.Screen

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        modifier= modifier,
        containerColor = Color(0xFF151515),
        contentColor = Color.White

    ) {
        val navigationItems = listOf(
            NavigationItem(
                title = "Home",
                icon = Icons.Default.Home,
                screen = Screen.Home,
                contentDescription= "home_page"
            ),
            NavigationItem(
                title = "About",
                icon = Icons.Default.Info,
                screen = Screen.About ,
                contentDescription= "about_page"

            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.contentDescription
                    )
                },
                label = { Text(item.title, style = MaterialTheme.typography.labelLarge) },
                selected = currentRoute == item.screen.route,
                colors = NavigationBarItemColors(
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    selectedIndicatorColor = Color.Transparent,
                    unselectedIconColor = Color(0xff4f4f4f),
                    unselectedTextColor = Color(0xff4f4f4f),
                    disabledIconColor = Color(0xff2f2f2f),
                    disabledTextColor = Color(0xff2f2f2f)
                ),
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }

            )
        }
    }
}