package com.theathletic.interview.articles.data.remote

data class RemoteArticle(
    val id: String,
    val body: String,
    val teamId: String?,
    val leagueId: String?,
    val title: String,
    val imageUrlString: String?,
    val authorId: String?
)