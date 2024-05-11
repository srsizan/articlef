package com.theathletic.interview.leagues.data

data class League(
    val createdAt: String,
    val deletedAt: Any,
    val id: String,
    val name: String,
    val shortName: String,
    val sportType: String,
    val title: String,
    val updatedAt: String
) {
    companion object {
        const val UNKNOWN = ""
    }
}