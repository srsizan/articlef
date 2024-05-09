package com.theathletic.interview.articleDetails.data

import com.theathletic.interview.articleDetails.data.remote.Author
import com.theathletic.interview.articleDetails.data.remote.League
import com.theathletic.interview.articleDetails.data.remote.Team

data class ArticleDetails(
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
) {
    companion object {
        const val UNKNOWN = ""
    }
}