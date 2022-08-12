package com.example.android.gamesredo.domain

import android.os.Parcelable
import com.example.android.gamesredo.LeagueRecord
import com.example.android.gamesredo.Records
import com.example.android.gamesredo.Streak
import com.example.android.gamesredo.Team
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StandingsModel(

    val team: Team? = Team(),
    val season: String? = null,
    val streak: Streak? = Streak(),
    val divisionRank: String? = null,
    val leagueRank: String? = null,
    val sportRank: String? = null,
    val gamesPlayed: Int? = null,
    val wins: Int? = null,
    val losses: Int? = null,
    val runDifferential: Int? = null,
    val winningPercentage: String? = null,
   val teamId: Int? = null,
    val teamName : String?



    ) : Parcelable