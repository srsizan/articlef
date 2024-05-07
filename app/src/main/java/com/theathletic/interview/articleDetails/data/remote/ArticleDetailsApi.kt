package com.theathletic.interview.articleDetails.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleDetailsApi {
    @GET("articles/{articleId}")
    suspend fun getArticleDetailsApi(@Path("articleId") articleId: String): RemoteArticleDetails
}