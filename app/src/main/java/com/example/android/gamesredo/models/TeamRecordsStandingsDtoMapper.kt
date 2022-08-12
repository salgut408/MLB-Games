package com.example.android.gamesredo.models

import com.example.android.gamesredo.SportDto
import com.example.android.gamesredo.TeamRecords
import com.example.android.gamesredo.db.standingsdb.StandingsDatabaseObj
import com.example.android.gamesredo.domain.SportModel
import com.example.android.gamesredo.domain.StandingsModel
import com.example.android.gamesredo.network.util.DomainMapper

class TeamRecordsStandingsDtoMapper: DomainMapper<TeamRecords, StandingsModel> {

    override fun mapToDomainModel(model: TeamRecords): StandingsModel {
        return StandingsModel(
            team = model.team,
            season = model.season,
            streak = model.streak,
            divisionRank = model.divisionRank,
            leagueRank = model.leagueRank,
            sportRank = model.sportRank,
            gamesPlayed = model.gamesPlayed,
            wins = model.wins,
            losses = model.losses,
            runDifferential = model.runDifferential,
            winningPercentage = model.winningPercentage,
        teamId = model.team?.id,
            teamName = model.team?.name
        )
    }

    fun mapToDatabaseObj(model: TeamRecords) : StandingsDatabaseObj {
       return StandingsDatabaseObj(
           teamName = model.team?.name.toString(),
           divisionRank = model.divisionRank,
           gamesPlayed = model.gamesPlayed,
           id = model.team?.id!!,
           leagueRank = model.leagueRank,
           losses = model.losses,
           runDifferential = model.runDifferential,
           season = model.season,
           sportRank = model.sportRank,
           wins = model.wins,
           winningPercentage = model.winningPercentage
       )
    }

     fun toDomainList(initial: List<TeamRecords>): List<StandingsModel>{
        return initial.map { mapToDomainModel(it) }
    }

    fun toDatabaseList(initial: List<TeamRecords>): List<StandingsDatabaseObj> {
        return initial.map {mapToDatabaseObj(it)}
    }




}

































