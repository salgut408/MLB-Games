package com.example.android.gamesredo.api

import com.example.android.gamesredo.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MlbApi {
    @GET("v1/schedule")
    suspend fun getGames(
        @Query("sportId")
        sportId: Int = 1
    ): Response<MlbResponse>


    @GET("v1/standings")
    suspend fun getStandings(
        @Query("leagueId")
        leagueId: Int = 103,
        @Query("leagueId")
    leagueId2: Int = 104
    ): Response<AmericanLeagueStandingResponse>

    @GET("v1/teams/{teamId}/roster")
    suspend fun getTeamInfo(
        @Path("teamId")
        teamId: Int? = null
    ): Response<TeamRosterResponse>

    @GET("v1/people/{personId}")
    suspend fun getPersonInfo(
        @Path("personId")
        teamId: Int? = null
    ): Response<PeopleResponse>


    @GET("v1/stats/leaders")
    suspend fun getHomeRunLeaders(
        @Query("season")
        season: Int? = 2022,
        @Query("leaderCategories")
        leaderCategories: String? = "homeruns"

    ): Response<LeagueLeadersResponse>

}