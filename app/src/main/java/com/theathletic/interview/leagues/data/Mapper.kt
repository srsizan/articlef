package com.theathletic.interview.leagues.data

import com.theathletic.interview.leagues.data.remote.RemoteLeagues
import com.theathletic.interview.leagues.ui.LeagueUiModel

fun RemoteLeagues.toDomain() = League(
    createdAt = createdAt,
    deletedAt = deletedAt ?: "",
    id = id,
    name = name,
    shortName = shortName,
    sportType = sportType,
    title = title,
    updatedAt = updatedAt
)

fun League.toUiModel() = LeagueUiModel(
    name = name,
    shortName = shortName,
    sportType = sportType,
    id = id
)