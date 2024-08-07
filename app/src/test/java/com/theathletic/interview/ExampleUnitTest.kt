package com.theathletic.interview

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.theathletic.interview.articleDetails.data.ArticleDetails
import com.theathletic.interview.articleDetails.data.ArticleDetailsRepository
import com.theathletic.interview.articleDetails.data.remote.ArticleDetailsApi
import com.theathletic.interview.articleDetails.data.remote.Author
import com.theathletic.interview.articleDetails.data.remote.League
import com.theathletic.interview.articleDetails.data.remote.RemoteArticleDetails
import com.theathletic.interview.articleDetails.data.remote.Team
import com.theathletic.interview.articleDetails.ui.ArticleDetailsViewModel
import com.theathletic.interview.articles.data.remote.ArticleApi
import com.theathletic.interview.leagues.data.League
import com.theathletic.interview.leagues.data.LeagueRepository
import com.theathletic.interview.leagues.ui.LeaguesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class ExampleUnitTest {


    private lateinit var articlesViewModel: LeaguesViewModel
    private lateinit var articleDetailsViewModel: ArticleDetailsViewModel

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var articleApi: ArticleApi

    @Mock
    lateinit var articleDetailsApi: ArticleDetailsApi

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(Dispatchers.IO)
        articlesViewModel = LeaguesViewModel(articleRepository = LeagueRepository(articleApi))
        articleDetailsViewModel = ArticleDetailsViewModel(
            articleDetailsRepository = ArticleDetailsRepository(articleDetailsApi)
        )
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun TestGetArticles() = runTest {
        val mockData = listOf(
            RemoteArticle("1", "", "", "", "", "", ""),
            RemoteArticle("2", "", "", "", "", "", ""),
            RemoteArticle("3", "", "", "", "", "", ""),
            RemoteArticle("4", "", "", "", "", "", ""),
        )
        Mockito.`when`(articleApi.getArticles()).thenReturn(mockData)
        val data = listOf(
            com.theathletic.interview.leagues.data.League("1", "", "", "", "", "", ""),
            com.theathletic.interview.leagues.data.League("2", "", "", "", "", "", ""),
            com.theathletic.interview.leagues.data.League("3", "", "", "", "", "", ""),
            com.theathletic.interview.leagues.data.League("4", "", "", "", "", "", ""),
        )
        val sut = LeagueRepository(articleApi)
        val result = sut.getArticles()

        Assert.assertEquals(result, data)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun TestGetArticleDetails() = runTest {
        val mockData = RemoteArticleDetails(
            Author(""), "", "", "", "",
            "", League(""), Team(""), "", ""
        )
        Mockito.`when`(articleDetailsApi.getArticleDetailsApi("test")).thenReturn(mockData)
        val data = ArticleDetails(
            Author(""), "", "", "", "",
            "", League(""), Team(""), "", ""
        )
        val sut = ArticleDetailsRepository(articleDetailsApi)
        val result = sut.getArticlesDetails("test")

        Assert.assertEquals(result, data)
    }

}
