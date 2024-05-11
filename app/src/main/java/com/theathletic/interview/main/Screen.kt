package com.theathletic.interview.main

/**
 * Sealed class representing different screens in the app with their respective routes.
 */
sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object ArticleDetailsScreen : Screen("article_details_screen")
    object ArticlesScreen : Screen("article_screen")
}