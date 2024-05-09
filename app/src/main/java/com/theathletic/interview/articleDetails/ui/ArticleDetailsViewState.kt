package com.theathletic.interview.articleDetails.ui

data class ArticleDetailsViewState(
    val isLoading: Boolean = true,
    val ArticleDetailModels: ArticleDetailUiModel = ArticleDetailUiModel("", "", "")
)

sealed interface ArticleDetailEvent {
    object ShowSomeMessage : ArticleDetailEvent
}