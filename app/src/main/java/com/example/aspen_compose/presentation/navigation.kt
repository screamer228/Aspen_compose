package com.example.aspen_compose.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
            WelcomeScreen(onNavigateToMainScreen = { navController.navigate("mainScreen") })
        }
        composable("mainScreen") {
            MainScreen()
        }
    }
}