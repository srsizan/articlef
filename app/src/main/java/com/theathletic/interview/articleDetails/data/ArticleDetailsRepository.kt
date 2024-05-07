package com.theathletic.interview.articleDetails.data

import com.theathletic.interview.articleDetails.data.remote.ArticleDetailsApi


class ArticleDetailsRepository(private val articleApi: ArticleDetailsApi) {

    suspend fun getArticlesDetails(id: String): ArticleDetails {
        return articleApi.getArticleDetailsApi(id).toDomain()
    }
}