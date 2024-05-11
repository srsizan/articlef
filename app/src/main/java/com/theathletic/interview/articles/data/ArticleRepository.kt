package com.theathletic.interview.articles.data

import com.theathletic.interview.articles.data.remote.ArticleApi

class ArticleRepository(private val articleApi: ArticleApi) {

    suspend fun getArticles(): List<Article> {
        val remoteArticles = articleApi.getArticles() ?: emptyList() // Return empty list if null
        return remoteArticles.map { it.toDomain() }
    }
}