package com.example.android.gamesredo.db.todaysgamesdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.gamesredo.domain.GamesModel

@Entity(tableName = "games_dataBase")
data class GamesDatabaseObj(
    val awayScore: Int?,
    val homeScore: Int?,
    val dayNight: String,
    @PrimaryKey(autoGenerate = false)
    val gamePk: Int,
    val season: String,
    val awayTeamName: String,
    val homeTeamName: String,
    val seriesDesc: String,
    val gamesInSeries: String,
    val seriesGameNumber: String,
    val isWatched: Boolean = false
)

fun List<GamesModel>.asDatabaseEntity(): List<GamesDatabaseObj> {
    return map {
        GamesDatabaseObj (
            awayScore = it.awayScore,
            homeScore = it.homeScore,
            dayNight = it.dayNight.toString(),
            gamePk = it.gamePk!!,
            season = it.season.toString(),
            awayTeamName = it.awayTeamName.toString(),
            homeTeamName = it.homeTeamName.toString(),
            seriesDesc = it.seriesDescription.toString(),
            gamesInSeries = it.gamesInSeries.toString(),
            seriesGameNumber = it.seriesGameNumber.toString()
                )
    }
}