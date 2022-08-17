package com.example.android.gamesredo.api

import com.example.android.gamesredo.*
import com.example.android.gamesredo.models.GameDetailResponse
import com.example.android.gamesredo.models.GamePredictionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


//enum class StandingsFilter(val value: String) {SHOW_AL("103"), SHOW_NL("104")}


interface MlbApi {
    @GET("v1/schedule")
    suspend fun getGames(
        @Query("sportId")
        sportId: Int = 1,
    ): Response<MlbResponse>

    @GET("v1/teams")
    suspend fun getAllTheTeamsInHistory(

    ): Response<AllTeamsResponse>


    @GET("v1/standings")
    suspend fun getStandings(
        @Query("leagueId")
        leagueId: Int = 103,
        @Query("leagueId")
        leagueId2: Int = 104,
    ): Response<AmericanLeagueStandingResponse>

    @GET("v1/teams/{teamId}/roster")
    suspend fun getTeamInfo(
        @Path("teamId")
        teamId: Int? = null,
    ): Response<TeamRosterResponse>

    @GET("v1/people/{personId}")
    suspend fun getPersonInfo(
        @Path("personId")
        teamId: Int? = null,
    ): Response<PeopleResponse>


    @GET("v1/stats/leaders")
    suspend fun getHomeRunLeaders(
        @Query("season")
        season: Int? = 2022,
        @Query("leaderCategories")
        leaderCategories: String? = "homeruns",

        ): Response<LeagueLeadersResponse>

    @GET("v1/stats/leaders")
    suspend fun getHomeRunLeadersPerTeam(
        @Query("season")
        season: Int? = 2022,
        @Query("leaderCategories")
        leaderCategories: String? = "homeruns",
        @Query("teamIds")
        teamIds: Int? = null
    ): Response<LeagueLeadersResponse>

    @GET("v1/teams/history")
    suspend fun getTeamHistoryInfo(
        @Query("teamIds")
        teamIds: Int? = null
    ): Response<TeamHistoryResponse>

    @GET("v1/game/{gamePk}/linescore")
    suspend fun getLineScore(
        @Path("gamePk")
        gamePk: Int? = null,
    ): Response<GameDetailResponse>

    @GET("v1/game/{gamePk}/contextMetrics")
    suspend fun getGamePredictions(
        @Path("gamePk")
        gamePk: Int? = null,
    ): Response<GamePredictionResponse>

    @GET("v1/game/{gamePk}/content")
        suspend fun getGameContent(
        @Path("gamePk")
        gamePk: Int? = null,
    ): Response<GameContentResponse>


    @GET("v1/game/{gamePk}/playByPlay")
    suspend fun getGamePlayByPlay(
        @Path("gamePk")
        gamePk: Int? = null,
    ): Response<PlayByPlayResponse>



}