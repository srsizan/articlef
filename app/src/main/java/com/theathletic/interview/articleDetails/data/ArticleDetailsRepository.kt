package com.theathletic.interview.articleDetails.data

import com.theathletic.interview.articleDetails.data.remote.ArticleDetailsApi


class ArticleDetailsRepository(private val articleDetailsApi: ArticleDetailsApi) {

    suspend fun getArticlesDetails(id: String): ArticleDetails {
        return articleDetailsApi.getArticleDetailsApi(id).toDomain()
    }
}