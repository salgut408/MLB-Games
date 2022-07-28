package com.example.android.gamesredo.repository

import android.content.Context
import android.util.Log
import com.example.android.gamesredo.MlbColorResponse
import com.example.android.gamesredo.api.MlbApi
import com.example.android.gamesredo.db.VenueDatabase
import com.example.android.gamesredo.domain.PeopleModel
import com.example.android.gamesredo.domain.RosterModel
import com.example.android.gamesredo.domain.StandingsModel
import com.example.android.gamesredo.models.PeopleDtoMapper
import com.example.android.gamesredo.models.RosterDtoMapper
import com.example.android.gamesredo.models.TeamRecordsStandingsDtoMapper
import com.example.android.gamesredo.util.Constants.Companion.getJsonDataFromAsset
import com.google.gson.Gson
import javax.inject.Inject

class GameRepository @Inject constructor(
    val db: VenueDatabase,
    val api: MlbApi,
    val context: Context,
    val mapper: TeamRecordsStandingsDtoMapper,
    val rosterMapr: RosterDtoMapper,
    val pplMappr: PeopleDtoMapper
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

//    suspend fun getRoster(teamId: Int) =
//        api.getTeamInfo(teamId)

    suspend fun getRoster(teamId: Int): List<RosterModel>{
        val result = api.getTeamInfo(teamId).body()!!.roster
    return rosterMapr.toDomainList(result)
    }

//    suspend fun getPersonInfo(personId: Int) =
//        api.getPersonInfo(personId)

    suspend fun getPersonInfo(personId: Int): PeopleModel {
        val result = api.getPersonInfo(personId).body()!!.people[0]
        return pplMappr.mapToDomainModel(result)
    }

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