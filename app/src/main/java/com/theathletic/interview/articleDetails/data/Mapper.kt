package com.theathletic.interview.articleDetails.data

import com.theathletic.interview.articleDetails.data.remote.RemoteArticleDetails
import com.theathletic.interview.articleDetails.ui.ArticleDetailUiModel

/**
 * Extension function to convert a [RemoteArticleDetails] object to an [ArticleDetails] object.
 *
 * @return An instance of [ArticleDetails] converted from [RemoteArticleDetails].
 */
fun RemoteArticleDetails.toDomain() = ArticleDetails(
    author = author,
    body = body,
    createdAt = createdAt,
    deletedAt = deletedAt ?: "",
    id = id,
    imageUrlString = imageUrlString,
    league = league,
    team = team,
    title = title,
    updatedAt = updatedAt
)

/**
 * Extension function to convert an [ArticleDetails] object to an [ArticleDetailUiModel] object.
 *
 * @return An instance of [ArticleDetailUiModel] converted from [ArticleDetails].
 */
fun ArticleDetails.toUiModel() = ArticleDetailUiModel(
    title = title,
    imageUrl = imageUrlString,
    body = body
)