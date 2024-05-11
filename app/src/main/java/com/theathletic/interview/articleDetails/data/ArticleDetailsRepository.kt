package com.theathletic.interview.articleDetails.data

import com.theathletic.interview.articleDetails.data.remote.ArticleDetailsApi

/**
 * Repository responsible for fetching details of articles.
 *
 * @param articleDetailsApi An instance of [ArticleDetailsApi] used for fetching article details from the API.
 */
class ArticleDetailsRepository(private val articleDetailsApi: ArticleDetailsApi) {

    suspend fun getArticlesDetails(id: String): ArticleDetails {
        return articleDetailsApi.getArticleDetailsApi(id).toDomain()
    }
}