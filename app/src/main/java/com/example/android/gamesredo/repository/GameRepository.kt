package com.example.android.gamesredo.repository

import android.content.Context
import android.util.Log
import com.example.android.gamesredo.MlbColorResponse
import com.example.android.gamesredo.api.MlbApi
import com.example.android.gamesredo.db.VenueDatabase
import com.example.android.gamesredo.domain.StandingsModel
import com.example.android.gamesredo.models.TeamRecordsStandingsDtoMapper
import com.example.android.gamesredo.util.Constants.Companion.getJsonDataFromAsset
import com.google.gson.Gson
import javax.inject.Inject

class GameRepository @Inject constructor(
    val db: VenueDatabase,
    val api: MlbApi,
    val context: Context,
    val mapper: TeamRecordsStandingsDtoMapper
) {

//    suspend fun getSport(): List<SportModel> {
////        return mapper.toDomainList()
////        or
////       val result = api.getGames(1).body()?.dates[0].games
////        return mapper.toDomainList(result)
//
//    }

    suspend fun getRecords(leagueId: Int, leagueId2: Int): List<StandingsModel> {
        val result = api.getStandings(103, 104).body()!!.records[0].teamRecords
        return mapper.toDomainList(result)
    }

    suspend fun getGames(sportId: Int) =
        api.getGames(1)


//    suspend fun getRecords(leagueId: Int, leagueId2: Int) =
//        api.getStandings(103, 104)

    suspend fun getRoster(teamId: Int) =
        api.getTeamInfo(teamId)

    suspend fun getPersonInfo(personId: Int) =
        api.getPersonInfo(personId)


    suspend fun getHomerunLeaders(season: Int, leaderCategories: String) =
        api.getHomeRunLeaders(season, leaderCategories)

     fun getColorData(): MlbColorResponse {
        val jsonFileString = getJsonDataFromAsset(this.context!!.applicationContext, "mlbcolor.json")
        Log.i("data", jsonFileString ?: "NOTHING")
        val gson = Gson()
//        val listMlbColorType = object : TypeToken<List<MlbColors>>() {}.type
        var colors: MlbColorResponse = gson.fromJson(jsonFileString, MlbColorResponse::class.java)
        return colors
    }


    //TODO wbere this go
//        val jsonFileString = Constants.getJsonDataFromAsset(this.context!!.applicationContext, "mlbcolor.json")
//        Log.i("data", jsonFileString ?: "NOTHING")
//        val gson = Gson()
//        val listMlbColorType = object : TypeToken<List<MlbColors>>() {}.type
//        var colors: List<MlbColors> = gson.fromJson(jsonFileString, listMlbColorType)
//        colors.forEachIndexed { idx, mlbColors -> Log.i("data",">Item $idx: /n${mlbColors}") }
//




}