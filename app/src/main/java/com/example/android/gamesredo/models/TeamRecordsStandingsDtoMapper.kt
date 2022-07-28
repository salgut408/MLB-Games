package com.example.android.gamesredo.models

import com.example.android.gamesredo.SportDto
import com.example.android.gamesredo.TeamRecords
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
            winningPercentage = model.winningPercentage
        )
    }


     fun toDomainList(initial: List<TeamRecords>): List<StandingsModel>{
        return initial.map { mapToDomainModel(it) }
    }




}

































