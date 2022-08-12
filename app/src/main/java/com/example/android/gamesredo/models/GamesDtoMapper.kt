package com.example.android.gamesredo.models

import com.example.android.gamesredo.Games
import com.example.android.gamesredo.db.todaysgamesdb.GamesDatabaseObj
import com.example.android.gamesredo.domain.GamesModel
import com.example.android.gamesredo.network.util.DomainMapper

class GamesDtoMapper: DomainMapper<Games, GamesModel> {
    override fun mapToDomainModel(model: Games): GamesModel {
        return GamesModel(
            content = model.content,
            dayNight = model.dayNight,
            doubleHeader = model.doubleHeader,
            gameDate = model.gameDate,
            gameNumber = model.gameNumber,
            gamePk = model.gamePk,
            gamesInSeries = model.gamesInSeries,
            gameType = model.gameType,
            link = model.link,
            officialDate = model.officialDate,
            recordSource = model.recordSource,
            scheduledInnings = model.scheduledInnings,
            season = model.season,
            seasonDisplay = model.seasonDisplay,
            seriesDescription = model.seriesDescription,
            seriesGameNumber = model.seriesGameNumber,
            status = model.status,
            teams = model.teams,
            venue = model.venue,
            homeScore = model.teams?.home?.score,
            awayScore = model.teams?.away?.score,
            awayTeamName = model.teams?.away?.team?.name,
            homeTeamName = model.teams?.home?.team?.name
        )
    }

    fun mapToDatabaseObj(model: Games) : GamesDatabaseObj {
        return GamesDatabaseObj(
            homeScore = model.teams?.home?.score,
            awayScore = model.teams?.away?.score,
            awayTeamName = model.teams?.away?.team?.name.toString(),
            homeTeamName = model.teams?.home?.team?.name.toString(),
            dayNight = model.dayNight.toString(),
            gamePk = model.gamePk!!,
            season = model.season.toString(),
            seriesGameNumber = model.seriesGameNumber.toString(),
            seriesDesc = model.seriesDescription.toString(),
            gamesInSeries = model.gamesInSeries.toString()
        )
    }

    fun toDomainList(initial: List<Games>): List<GamesModel>{
        return initial.map { mapToDomainModel(it) }
    }
    fun toDatabaseList(initial: List<Games>): List<GamesDatabaseObj>{
        return initial.map { mapToDatabaseObj(it) }
    }
}