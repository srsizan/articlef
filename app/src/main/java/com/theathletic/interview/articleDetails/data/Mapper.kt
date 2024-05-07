package com.theathletic.interview.articleDetails.data

import com.theathletic.interview.articleDetails.data.remote.RemoteArticleDetails
import com.theathletic.interview.articleDetails.ui.ArticleDetailsUiModel

fun RemoteArticleDetails.toDomain() = ArticleDetails(
    author = author,
    body = body,
    createdAt = createdAt,
    deletedAt = deletedAt,
    id = id,
    imageUrlString = imageUrlString,
    league = league,
    team = team,
    title = title,
    updatedAt = updatedAt
)

fun ArticleDetails.toUiModel() = ArticleDetailsUiModel(
    title = title,
    imageUrl = imageUrlString,
    body = body
)