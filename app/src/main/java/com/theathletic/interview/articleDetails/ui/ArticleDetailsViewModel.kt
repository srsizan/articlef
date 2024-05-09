package com.theathletic.interview.articleDetails.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theathletic.interview.articleDetails.data.ArticleDetails
import com.theathletic.interview.articleDetails.data.ArticleDetailsRepository
import com.theathletic.interview.articleDetails.data.toUiModel
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
    private val _viewState = MutableStateFlow(ArticleDetailsViewState())
    private val _viewEvent = MutableSharedFlow<ArticleDetailEvent>()
    val viewState = _viewState.asStateFlow()
    val viewEvent: Flow<ArticleDetailEvent> = _viewEvent

    fun getArticleDetails(id: String){
        viewModelScope.launch {
            val articleDetails = repository.getArticlesDetails(id)
           onArticleDetailsLoaded(articleDetails)
        }
    }

    private fun onArticleDetailsLoaded(articleDetails: ArticleDetails) {
        _viewState.updateState {
            copy(ArticleDetailModels= articleDetails.toUiModel() , isLoading = false)
        }
    }
}