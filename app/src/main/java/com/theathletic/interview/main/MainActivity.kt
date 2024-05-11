package com.theathletic.interview.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.theathletic.interview.R
import com.theathletic.interview.articleDetails.ui.ArticleDetailsViewModel
import com.theathletic.interview.articles.ui.ArticlesScreen
import com.theathletic.interview.articles.ui.ArticlesViewModel
import com.theathletic.interview.leagues.ui.LeaguesScreen
import com.theathletic.interview.leagues.ui.LeaguesViewModel
import com.theathletic.interview.ui.theme.AthleticTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AthleticTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation()
                }
            }
        }
    }

    sealed class Screen(
        @StringRes val resourceTitle: Int, @DrawableRes val resourceIcon: Int
    ) {
        object Articles : Screen(R.string.title_articles, R.drawable.ic_articles)
        object Leagues : Screen(R.string.title_leagues, R.drawable.ic_leagues)
    }
}

@Composable
fun MainScreenView(
    navController: NavHostController,
    articlesViewModel: ArticlesViewModel,
    articleDetailsViewModel: ArticleDetailsViewModel,
    leaguesViewModel: LeaguesViewModel
) {

    var selectedScreen by remember { mutableStateOf(MainActivity.Screen.Articles as MainActivity.Screen) }
    Scaffold(bottomBar = {
        BottomNavigation(
            selectedScreen,
        ) { screen -> selectedScreen = screen }
    }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            when (selectedScreen) {
                MainActivity.Screen.Articles -> {
                    ArticlesScreen(articlesViewModel, articleDetailsViewModel, navController)
                }

                MainActivity.Screen.Leagues -> {
                    LeaguesScreen(leaguesViewModel, navController = navController)
                }
            }
        }
    }
}

@Composable
fun BottomNavigation(
    selectedScreen: MainActivity.Screen,
    onScreenSelected: (MainActivity.Screen) -> Unit
) {
    val items = listOf(MainActivity.Screen.Articles, MainActivity.Screen.Leagues)
    val context = LocalContext.current
    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(selected = item == selectedScreen,
                icon = {
                    Icon(
                        painterResource(id = item.resourceIcon),
                        contentDescription = context.getString(item.resourceTitle)
                    )
                },
                label = { Text(text = context.getString(item.resourceTitle), fontSize = 10.sp) },
                onClick = { onScreenSelected(item) })
        }
    }
}
