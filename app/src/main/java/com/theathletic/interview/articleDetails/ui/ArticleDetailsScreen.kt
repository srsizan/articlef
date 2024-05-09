package com.theathletic.interview.articleDetails.ui

import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.theathletic.interview.core.collectWithLifecycle

class ArticleDetailUiModel(
    val title: String,
    val body: String? = null,
    val imageUrl: String?
)
@Composable
fun ArticleDetailsScreen(
    navController: NavHostController,
    articleDetailsViewModel: ArticleDetailsViewModel
) {
    val state by articleDetailsViewModel.viewState.collectAsState(initial = ArticleDetailsViewState(true, ArticleDetailModels = ArticleDetailUiModel("","","")))

    articleDetailsViewModel.viewEvent.collectWithLifecycle { //event->
//        when (event){
//          here you can handle one-off events
//        }
    }
    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }


    Spacer(modifier = Modifier.width(8.dp))
    Column(Modifier
        .padding(3.dp, 6.dp,3.dp, 0.dp)
        .verticalScroll(state = rememberScrollState())
    ) {
        Text(text = state.ArticleDetailModels.title)
        Spacer(modifier = Modifier.height(8.dp))
        AsyncImage(
            model = state.ArticleDetailModels.imageUrl,
            contentDescription = "News image",
            modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(8.dp))
        state.ArticleDetailModels.body?.let { Text(text = it) }
    }

}