package com.example.aspen_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aspen_compose.presentation.detail_screen.DetailScreen
import com.example.aspen_compose.presentation.main_screen.MainScreen
import com.example.aspen_compose.presentation.welcome_screen.WelcomeScreen

const val ROUTE_WELCOME = "welcome"
const val ROUTE_MAIN_SCREEN = "mainScreen"
const val ROUTE_DETAIL_SCREEN = "detailScreen/"
const val KEY_DETAIL_ROUTE = "index"
const val ARG_DETAIL_ROUTE = "{index}"

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ROUTE_WELCOME
    )
    {
        composable(ROUTE_WELCOME) {
            WelcomeScreen(navController)
        }
        composable(ROUTE_MAIN_SCREEN) {
            MainScreen(
                navController = navController
            )
        }
        composable("$ROUTE_DETAIL_SCREEN$ARG_DETAIL_ROUTE") { navBackStackEntry ->

            val index = navBackStackEntry.arguments?.getString(KEY_DETAIL_ROUTE)

            index?.let {
                DetailScreen(navController = navController, index = it.toInt())
            }
        }
    }
}
