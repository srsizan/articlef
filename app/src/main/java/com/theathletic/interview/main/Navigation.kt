package com.theathletic.interview.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theathletic.interview.articleDetails.ui.ArticleDetailsScreen
import com.theathletic.interview.articleDetails.ui.ArticleDetailsViewModel
import com.theathletic.interview.articles.ui.ArticlesScreen
import com.theathletic.interview.articles.ui.ArticlesViewModel
import com.theathletic.interview.leagues.ui.LeaguesViewModel
import org.koin.androidx.compose.viewModel

/**
 * Composable function for managing navigation within the app.
 */
@Composable
fun Navigation() {
    // val leaguesViewModel: LeaguesViewModel = hiltViewModel()
    val navController = rememberNavController()
    val articlesViewModel: ArticlesViewModel by viewModel()
    val articleDetailsViewModel: ArticleDetailsViewModel by viewModel()
    val leaguesViewModel: LeaguesViewModel by viewModel()
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            MainScreenView(
                navController,
                articlesViewModel,
                articleDetailsViewModel,
                leaguesViewModel
            )
        }
        composable(route = Screen.ArticleDetailsScreen.route) {
            ArticleDetailsScreen(navController, articleDetailsViewModel)
        }
        composable(route = Screen.ArticlesScreen.route) {
            ArticlesScreen(articlesViewModel, articleDetailsViewModel, navController)
        }

    }
}