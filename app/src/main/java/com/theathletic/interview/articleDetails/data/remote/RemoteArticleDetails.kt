package com.theathletic.interview.articleDetails.data.remote


/**
 * Remote Article Details Class for Getting Article Details
 */


data class RemoteArticleDetails(
    val author: Author,
    val body: String,
    val createdAt: String,
    val deletedAt: Any,
    val id: String,
    val imageUrlString: String,
    val league: League,
    val team: Team,
    val title: String,
    val updatedAt: String
)