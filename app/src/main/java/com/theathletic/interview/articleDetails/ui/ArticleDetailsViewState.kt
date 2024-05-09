package com.theathletic.interview.articleDetails.ui

import com.theathletic.interview.articles.ui.ArticleUiModel

data class ArticleDetailsViewState(
    val isLoading: Boolean = true,
    val ArticleDetailModels: ArticleDetailUiModel = ArticleDetailUiModel("","","")
)

sealed interface ArticleDetailEvent {
    object ShowSomeMessage : ArticleDetailEvent
}