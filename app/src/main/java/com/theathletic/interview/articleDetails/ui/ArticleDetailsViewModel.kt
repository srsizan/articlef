package com.theathletic.interview.articleDetails.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theathletic.interview.articleDetails.data.ArticleDetailsRepository
import com.theathletic.interview.articles.data.Article
import com.theathletic.interview.articles.data.ArticleRepository
import com.theathletic.interview.articles.data.toUiModel
import com.theathletic.interview.articles.ui.ArticleEvent
import com.theathletic.interview.articles.ui.ArticlesViewState
import com.theathletic.interview.core.updateState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ArticleDetailsViewModel(
    articleDetailsRepository: ArticleDetailsRepository
) : ViewModel() {
    val repository = articleDetailsRepository
    private val _viewState = MutableStateFlow(ArticlesViewState())
    private val _viewEvent = MutableSharedFlow<ArticleEvent>()
    val viewState = _viewState.asStateFlow()
    val viewEvent: Flow<ArticleEvent> = _viewEvent

    init {
        viewModelScope.launch {
            val articles = articleDetailsRepository.getArticlesDetails(id = "")
            //onArticlesLoaded(articles)
        }
    }

    fun getArticleDetails(id: String){
        viewModelScope.launch {
            val articles = repository.getArticlesDetails(id)
           // onArticlesLoaded(articles)
        }
    }

    private fun onArticlesLoaded(articles: List<Article>) {
        _viewState.updateState {
            copy(articleModels = articles.map { it.toUiModel() }, isLoading = false)
        }
    }
}