package com.theathletic.interview.leagues.data

import com.theathletic.interview.leagues.data.remote.LeagueApi

class LeagueRepository(private val leagueApi: LeagueApi) {


    suspend fun getLeagues(): List<League> {
        val remoteLeagues = leagueApi.getLeagues() ?: emptyList() // Return empty list if null
        return remoteLeagues.map { it.toDomain() }
    }
}