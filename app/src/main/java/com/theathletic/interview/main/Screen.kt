package com.theathletic.interview.main

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object ArticleDetailsScreen : Screen("article_details_screen")
}