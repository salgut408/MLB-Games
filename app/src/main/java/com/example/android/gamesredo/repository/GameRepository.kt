package com.example.android.gamesredo.repository

import android.content.Context
import android.util.Log
import com.example.android.gamesredo.*
import com.example.android.gamesredo.api.MlbApi
import com.example.android.gamesredo.db.standingsdb.StandingsDatabase
import com.example.android.gamesredo.db.venuedb.VenueDatabase
import com.example.android.gamesredo.db.todaysgamesdb.TodaysGamesDatabase
import com.example.android.gamesredo.domain.*
import com.example.android.gamesredo.models.*
import com.example.android.gamesredo.models.allteamslistresponse.json2kt_Kotlin_06.AllTeamDtoMApper
import com.example.android.gamesredo.models.contentresponspkg.ContentResponseDtoMapper
import com.example.android.gamesredo.models.playbyplay.json2kt_Kotlin_07.PlayByPlayDtoMapper
import com.example.android.gamesredo.util.Constants.Companion.dummyContentModel
import com.example.android.gamesredo.util.Constants.Companion.getJsonDataFromAsset
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameRepository @Inject constructor(
    val allTeamDtoMApper: AllTeamDtoMApper,
    val standingsDatabase: StandingsDatabase,
    val todaysGamesDatabase: TodaysGamesDatabase,
    val db: VenueDatabase,
    val api: MlbApi,
    val context: Context,
    val mapper: TeamRecordsStandingsDtoMapper,
    val rosterMapr: RosterDtoMapper,
    val pplMappr: PeopleDtoMapper,
    val gameMappr: GamesDtoMapper,
    val leaderMapper: LeadersDtoMapper,
    val histMapper: TeamsHistDtoMapper,
    val gameDetailDtoMapper: GameDetailDtoMapper,
    val gamePredictionDtoMapper: GamePredictionDtoMapper,
    val contentResponseDtoMapper: ContentResponseDtoMapper,
    val playByPlayDtoMapper: PlayByPlayDtoMapper,
//    val colorsDtoMapper: MlbColorsDtoMapper
) {
    //this is problem when an array list is empty...
    suspend fun getContent(gamePk: Int): ContentDetailModel {
        var result = api.getGameContent(gamePk).body()

        if (result?.highlights?.highlights2?.items?.isEmpty() == false) {

            return contentResponseDtoMapper.mapToDomainModel(result!!)

        }

        return dummyContentModel
    }


//    suspend fun getRecords(leagueId: Int, leagueId2: Int): List<StandingsModel> {
//        var result = api.getStandings(103, 104).body()!!.records[0].teamRecords
//        for (i in api.getStandings(103, 104).body()!!.records) {
//           result.addAll(i.teamRecords)

//        //fix first index getting added 2x
//        }
//        return mapper.toDomainList(result)
//    }

    suspend fun getGamePlayByPlay(gamePk: Int): PlayByPlayModel {
        var result = api.getGamePlayByPlay(gamePk).body()
        return playByPlayDtoMapper.mapToDomainModel(result!!)
    }




    val records: Flow<List<StandingsModel>> = flow {
        while (true) {

            var records = api.getStandings(103, 104).body()!!.records[0].teamRecords


//            for(i in 0 until  records.size) {
//                var hold = 0
//                emit(mapper.toDomainList(records[i].teamRecords))
//
//            }

//            for (i in api.getStandings(103, 104).body()!!.records) {
//                emit(mapper.toDomainList(i.teamRecords))
//            }


            for (i in api.getStandings(103, 104).body()!!.records) {

                records.addAll(i.teamRecords)

                emit(mapper.toDomainList(records.sortedBy { it.sportRank?.toInt() }))

            }


        }
    }


    suspend fun getGames(sportId: Int): List<GamesModel> {
        val result = api.getGames(1).body()!!.dates[0].games
        return gameMappr.toDomainList(result)
    }
    suspend fun getGamesForDatabase() {
        withContext(Dispatchers.IO) {
            try {
                val games = api.getGames(1).body()!!.dates[0].games

                val games2 = gameMappr.toDatabaseList(games)
                todaysGamesDatabase.getTodaysGamesDao().insertAll(games2)
                Log.i("ZUNK", "add to today game db works")
            } catch (err: Exception) {
                Log.i("ZUNK", "FAIL")

            }
        }
    }

    suspend fun getStandingsForDatabase() {
        withContext(Dispatchers.IO) {
            try{
                val standings = api.getStandings(103, 104).body()!!.records[0].teamRecords
                for (i in api.getStandings(103, 104).body()!!.records){
                    standings.addAll(i.teamRecords)

                }
                val standings2 = mapper.toDatabaseList(standings)
                standingsDatabase.getStandingsDao().insertAll(standings2)
                Log.i("Zunk", "Added standings db")
            } catch (err: Exception){
                Log.i("Zunk", "db fail")
            }
        }
    }

    val games: Flow<List<GamesModel>> = flow {
        while (true) {
            val games = api.getGames(1).body()!!.dates[0].games
            emit(gameMappr.toDomainList(games))
            Log.i("tag", "game api refresh")
            //delay 1 minute
            delay(60000)

        }
    }

    suspend fun getGamePredictions(gamePk: Int): GamePredictionModel {
        val result = api.getGamePredictions(gamePk).body()
        return gamePredictionDtoMapper.mapToDomainModel(result!!)
    }

    suspend fun getGameDetailLineScore(gamePk: Int): GameDetailModel {
        val result = api.getLineScore(gamePk).body()
        return gameDetailDtoMapper.mapToDomainModel(result!!)
    }


    suspend fun getRoster(teamId: Int): List<RosterModel> {
        val result = api.getTeamInfo(teamId).body()!!.roster
        return rosterMapr.toDomainList(result)
    }

    suspend fun getAllTeamsInHistory(): List<AllTeamModel> {
        var result = api.getAllTheTeamsInHistory().body()!!.allTeams

        return allTeamDtoMApper.toDomainList(result)


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
        var result =
            api.getHomeRunLeaders(season, leadersCatagories).body()!!.leagueLeaders[0].leaders
        for (i in api.getHomeRunLeaders(season, leadersCatagories).body()!!.leagueLeaders) {
            result.addAll(i.leaders)
        }
        // fix index 0 added


        return leaderMapper.toDomainList(result)
    }


    suspend fun getHomeRunLeadsByTeam(
        season: Int,
        leadersCatagories: String,
        teamIds: Int,
    ): List<LeadersModel> {
        val result = api.getHomeRunLeadersPerTeam(season, leadersCatagories, teamIds)
            .body()!!.leagueLeaders[0].leaders
        for (i in api.getHomeRunLeadersPerTeam(season, leadersCatagories, teamIds)
            .body()!!.leagueLeaders) {
            result.addAll(i.leaders)
        }
        return leaderMapper.toDomainList(result)

    }

    // maybe make colors DTO also ?
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
            getJsonDataFromAsset(this.context.applicationContext, "mlbcolor.json")
        Log.i("data", jsonFileString ?: "NOTHING")
        val gson = Gson()
//        val listMlbColorType = object : TypeToken<List<MlbColors>>() {}.type
        var colors: MlbColorResponse = gson.fromJson(jsonFileString, MlbColorResponse::class.java)
        return colors
    }





}