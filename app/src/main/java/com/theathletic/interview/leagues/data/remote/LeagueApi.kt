package com.theathletic.interview.leagues.data.remote

import retrofit2.http.GET

interface LeagueApi {
    @GET("leagues")
    suspend fun getLeagues(): List<RemoteLeagues>
}

