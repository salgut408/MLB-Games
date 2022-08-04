package com.example.android.gamesredo.repository

import android.content.Context
import android.util.Log
import com.example.android.gamesredo.Games
import com.example.android.gamesredo.MlbColorResponse
import com.example.android.gamesredo.TeamRecords
import com.example.android.gamesredo.api.MlbApi
import com.example.android.gamesredo.db.VenueDatabase
import com.example.android.gamesredo.domain.*
import com.example.android.gamesredo.models.*
import com.example.android.gamesredo.util.Constants.Companion.getJsonDataFromAsset
import com.google.gson.Gson
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
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
    val histMapper: TeamsHistDtoMapper,
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
        //TODO fix first index getting added 2x
        }
        return mapper.toDomainList(result)
    }

    val records: Flow<List<StandingsModel>> = flow {
        while (true){

            var records = api.getStandings(103, 104).body()!!.records[0].teamRecords

            for(i in api.getStandings(103, 104).body()!!.records){
                records.addAll(i.teamRecords)
                emit(mapper.toDomainList(records))

            }


        }
    }


//    suspend fun getGames(sportId: Int): List<GamesModel> {
//        val result = api.getGames(1).body()!!.dates[0].games
//        return gameMappr.toDomainList(result)
//    }

    val games: Flow<List<GamesModel>> = flow {
        while (true) {
            val games = api.getGames(1).body()!!.dates[0].games
            emit(gameMappr.toDomainList(games))
            Log.i("tag", "game api refresh")
            //delay 1 minute
            delay(60000)

        }
    }


    suspend fun getRoster(teamId: Int): List<RosterModel> {
        val result = api.getTeamInfo(teamId).body()!!.roster
        return rosterMapr.toDomainList(result)
    }




    suspend fun getPersonInfo(personId: Int): PeopleModel {
        val result = api.getPersonInfo(personId).body()!!.people[0]
        return pplMappr.mapToDomainModel(result)
    }

    suspend fun getTeamHistoryInfo(teamIds: Int): TeamsHistModel {
        val result = api.getTeamHistoryInfo(teamIds).body()!!.teamsHist[0]
        return histMapper.mapToDomainModel(result)
    }


    suspend fun getHomeRunLeaders(season: Int, leadersCatagories: String): List<LeadersModel> {
        var result = api.getHomeRunLeaders(season, leadersCatagories).body()!!.leagueLeaders[0].leaders
        for (i in api.getHomeRunLeaders(season, leadersCatagories).body()!!.leagueLeaders) {
            result.addAll(i.leaders)
        }
        //TODO fix index 0 added





        return leaderMapper.toDomainList(result)
    }


    suspend fun getHomeRunLeadsByTeam(season: Int, leadersCatagories: String, teamIds: Int): List<LeadersModel> {
        val result=api.getHomeRunLeadersPerTeam(season, leadersCatagories, teamIds).body()!!.leagueLeaders[0].leaders
        for (i in api.getHomeRunLeadersPerTeam(season, leadersCatagories, teamIds).body()!!.leagueLeaders){
            result.addAll(i.leaders)
        }
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