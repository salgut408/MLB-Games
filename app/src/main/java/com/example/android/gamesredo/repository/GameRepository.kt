package com.example.android.gamesredo.repository

import com.example.android.gamesredo.api.MlbApi
import com.example.android.gamesredo.db.VenueDatabase
import javax.inject.Inject

class GameRepository @Inject constructor (
    val db: VenueDatabase, val api: MlbApi
) {

suspend fun getGames(sportId: Int) =
  api.getGames(1)


suspend fun getRecords(leagueId: Int, leagueId2: Int) =
    api.getStandings(103, 104)

suspend fun getRoster(teamId: Int)=
    api.getTeamInfo(teamId)

suspend fun getPersonInfo(personId: Int) =
    api.getPersonInfo(personId)

}