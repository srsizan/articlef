package com.theathletic.interview.articleDetails.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

class ArticleDetailsUiModel(
    val title: String,
    val body: String? = null,
    val imageUrl: String?
)
@Composable
fun ArticleDetailsScreen(navController: NavHostController) {
    Text("Hello From Article Details Screen")
}