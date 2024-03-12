package com.example.aspen_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aspen_compose.presentation.detail_screen.DetailScreen
import com.example.aspen_compose.presentation.main_screen.MainScreen
import com.example.aspen_compose.presentation.welcome_screen.WelcomeScreen

@Composable
fun Navigation(
    navController : NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "welcome"
    )
    {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("mainScreen") {
            MainScreen(
                navController = navController
            )
        }
        composable("detailScreen/{index}") { navBackStackEntry ->
            /* Extracting the id from the route */
            val index = navBackStackEntry.arguments?.getString("index")
            /* We check if is null */
            index?.let {
                DetailScreen(navController = navController, index = it.toInt())
            }
        }
    }
}