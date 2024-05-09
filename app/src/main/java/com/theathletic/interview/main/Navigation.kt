package com.theathletic.interview.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theathletic.interview.articleDetails.ui.ArticleDetailsScreen

@Composable
fun Navigation() {
    // val leaguesViewModel: LeaguesViewModel = hiltViewModel()
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            MainScreenView(navController)
        }
        composable(route = Screen.ArticleDetailsScreen.route) {
            ArticleDetailsScreen(navController)
        }

    }
}