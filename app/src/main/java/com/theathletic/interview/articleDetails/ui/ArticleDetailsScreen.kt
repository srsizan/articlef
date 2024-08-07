package com.theathletic.interview.articleDetails.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.theathletic.interview.R
import com.theathletic.interview.core.collectWithLifecycle
import com.theathletic.interview.main.Screen

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
    val state by articleDetailsViewModel.viewState.collectAsState(
        initial = ArticleDetailsViewState(
            true,
            ArticleDetailModels = ArticleDetailUiModel("", "", "")
        )
    )

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


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Article Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Screen.HomeScreen.route) }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }

                }
            )
        }
    ) {
        Column(
            Modifier
                .padding(paddingValues = it)
                .verticalScroll(state = rememberScrollState())
        ) {
            Text(
                modifier = Modifier.padding(5.dp),
                text = state.ArticleDetailModels.title,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            AsyncImage(
                model = state.ArticleDetailModels.imageUrl,
                contentDescription = "News image",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            state.ArticleDetailModels.body?.let { body ->
                Text(
                    modifier = Modifier
                        .padding(5.dp),
                    text = body)
            }
        }
    }
}