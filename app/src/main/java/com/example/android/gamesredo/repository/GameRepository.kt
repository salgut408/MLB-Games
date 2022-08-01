package com.example.android.gamesredo.repository

import android.content.Context
import android.util.Log
import com.example.android.gamesredo.MlbColorResponse
import com.example.android.gamesredo.Records
import com.example.android.gamesredo.TeamRecords
import com.example.android.gamesredo.api.MlbApi
import com.example.android.gamesredo.db.VenueDatabase
import com.example.android.gamesredo.domain.*
import com.example.android.gamesredo.models.*
import com.example.android.gamesredo.util.Constants.Companion.getJsonDataFromAsset
import com.google.gson.Gson
import javax.inject.Inject

class GameRepository @Inject constructor(
    val db: VenueDatabase,
    val api: MlbApi,
    val context: Context,
    val mapper: TeamRecordsStandingsDtoMapper,
    val rosterMapr: RosterDtoMapper,
    val pplMappr: PeopleDtoMapper,
    val gameMappr: GamesDtoMapper,
    val leaderMapper: LeadersDtoMapper,
//    val colorsDtoMapper: MlbColorsDtoMapper
) {

//    suspend fun getSport(): List<SportModel> {
////        return mapper.toDomainList()
////        or
////       val result = api.getGames(1).body()?.dates[0].games
////        return mapper.toDomainList(result)
//
//    }

    suspend fun getRecords(leagueId: Int, leagueId2: Int): List<StandingsModel> {
        var result = api.getStandings(103, 104).body()!!.records[0].teamRecords
        for (i in api.getStandings(103, 104).body()!!.records) {
           result.addAll(i.teamRecords)
        //TODO fix first index getting added twice
        }
        return mapper.toDomainList(result)
    }


    suspend fun getGames(sportId: Int): List<GamesModel> {
        val result = api.getGames(1).body()!!.dates[0].games
        return gameMappr.toDomainList(result)
    }


    suspend fun getRoster(teamId: Int): List<RosterModel> {
        val result = api.getTeamInfo(teamId).body()!!.roster
        return rosterMapr.toDomainList(result)
    }


    suspend fun getPersonInfo(personId: Int): PeopleModel {
        val result = api.getPersonInfo(personId).body()!!.people[0]
        return pplMappr.mapToDomainModel(result)
    }


    suspend fun getHomeRunLeaders(season: Int, leadersCatagories: String): List<LeadersModel> {
        var result = api.getHomeRunLeaders(season, leadersCatagories).body()!!.leagueLeaders[0].leaders
        for (i in api.getHomeRunLeaders(season, leadersCatagories).body()!!.leagueLeaders) {
            result.addAll(i.leaders)
        }
        //TODO fix index 0 added twice



        return leaderMapper.toDomainList(result)
    }
    //TODO maybe make colors DTO also ?
//    suspend fun getColorDataM(): List<MlbColorsModel>{
//        val jsonFileString =
//            getJsonDataFromAsset(this.context!!.applicationContext, "mlbcolor.json")
//        Log.i("data", jsonFileString ?: "NOTHING")
//        val gson = Gson()
////        val listMlbColorType = object : TypeToken<List<MlbColors>>() {}.type
//        var result: MlbColorResponse = gson.fromJson(jsonFileString, MlbColorResponse::class.java)
//        return colorsDtoMapper.toDomainList(result.mlbColors)
//    }

    fun getColorData(): MlbColorResponse {
        val jsonFileString =
            getJsonDataFromAsset(this.context!!.applicationContext, "mlbcolor.json")
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