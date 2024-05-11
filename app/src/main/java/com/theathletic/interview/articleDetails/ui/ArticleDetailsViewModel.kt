package com.theathletic.interview.articleDetails.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.theathletic.interview.articleDetails.data.ArticleDetails
import com.theathletic.interview.articleDetails.data.ArticleDetailsRepository
import com.theathletic.interview.articleDetails.data.toUiModel
import com.theathletic.interview.core.updateState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel responsible for managing article details data and events.
 *
 * @param articleDetailsRepository The repository for fetching article details.
 */
class ArticleDetailsViewModel(
    articleDetailsRepository: ArticleDetailsRepository
) : ViewModel() {
    val repository = articleDetailsRepository
    private var _viewState = MutableStateFlow(ArticleDetailsViewState())
    private val _viewEvent = MutableSharedFlow<ArticleDetailEvent>()
    val viewState = _viewState.asStateFlow()
    val viewEvent: Flow<ArticleDetailEvent> = _viewEvent

    /**
     * Fetches details of the article with the specified ID.
     *
     * @param id The unique identifier of the article.
     */
    fun getArticleDetails(id: String) {
        //To release previous stored info
        _viewState.updateState {
            copy(ArticleDetailModels = ArticleDetailUiModel("", "", ""), isLoading = true)
        }
        viewModelScope.launch {
            val articleDetails = repository.getArticlesDetails(id)
            onArticleDetailsLoaded(articleDetails)
        }
    }

    /**
     * Handles the loaded article details.
     *
     * @param articleDetails The loaded article details.
     */
    private fun onArticleDetailsLoaded(articleDetails: ArticleDetails) {
        _viewState.updateState {
            copy(ArticleDetailModels = articleDetails.toUiModel(), isLoading = false)
        }
    }
}