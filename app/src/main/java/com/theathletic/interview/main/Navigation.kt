package com.theathletic.interview.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theathletic.interview.articleDetails.ui.ArticleDetailsScreen
import com.theathletic.interview.articleDetails.ui.ArticleDetailsViewModel
import com.theathletic.interview.articles.ui.ArticlesViewModel
import org.koin.androidx.compose.viewModel

@Composable
fun Navigation() {
    // val leaguesViewModel: LeaguesViewModel = hiltViewModel()
    val navController = rememberNavController()
    val articlesViewModel: ArticlesViewModel by viewModel()
    val articleDetailsViewModel: ArticleDetailsViewModel by viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            MainScreenView(navController, articlesViewModel, articleDetailsViewModel)
        }
        composable(route = Screen.ArticleDetailsScreen.route) {
            ArticleDetailsScreen(navController,articleDetailsViewModel)
        }

    }
}