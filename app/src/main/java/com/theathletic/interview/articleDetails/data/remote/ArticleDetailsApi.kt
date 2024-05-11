package com.theathletic.interview.articleDetails.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interface representing an API for retrieving details of an article.
 */
interface ArticleDetailsApi {
    @GET("articles/{articleId}")
    suspend fun getArticleDetailsApi(@Path("articleId") articleId: String): RemoteArticleDetails
}