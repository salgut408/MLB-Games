package com.example.android.gamesredo.db.standingsdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.gamesredo.Team
import com.example.android.gamesredo.domain.StandingsModel

@Entity(tableName = "standings_database")
data class StandingsDatabaseObj(
    val teamName: String,
    val season: String? = null,
    val divisionRank: String? = null,
    val leagueRank: String? = null,
    val sportRank: String? = null,
    val gamesPlayed: Int? = null,
    val wins: Int? = null,
    val losses: Int? = null,
    val runDifferential: Int? = null,
    val winningPercentage: String? = null,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
)

fun List<StandingsModel>.asDatabaseEntity(): List<StandingsDatabaseObj>{
    return map {
        StandingsDatabaseObj(
            teamName = it.teamName!!,
            season = it.season,
            divisionRank = it.divisionRank,
            leagueRank = it.leagueRank,
            sportRank = it.sportRank,
            gamesPlayed = it.gamesPlayed,
            wins = it.wins,
            losses = it.losses,
            runDifferential = it.runDifferential,
            winningPercentage = it.winningPercentage,
            id = it.teamId!!

        )
    }
}
