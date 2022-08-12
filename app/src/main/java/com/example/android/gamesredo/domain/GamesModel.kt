package com.example.android.gamesredo.domain

import android.os.Parcelable
import com.example.android.gamesredo.Content
import com.example.android.gamesredo.Status
import com.example.android.gamesredo.Teams
import com.example.android.gamesredo.Venue
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GamesModel(
    val gamePk                 : Int?     = null,
    val link                   : String?  = null,
    val gameType               : String?  = null,
    val season                 : String?  = null,
    val gameDate               : String?  = null,
    val officialDate           : String?  = null,
    val status                 : Status?  = Status(),
    val teams                  : Teams?   = Teams(),
    val venue                  : Venue?   = Venue(),
    val content                : Content? = Content(),
    val gameNumber             : Int?     = null,
    val doubleHeader           : String?  = null,
    val seasonDisplay          : String?  = null,
    val dayNight               : String?  = null,
    val scheduledInnings       : Int?     = null,
    val gamesInSeries          : Int?     = null,
    val seriesGameNumber       : Int?     = null,
    val seriesDescription      : String?  = null,
    val recordSource           : String?  = null,
    val homeScore: Int? = null,
    val awayScore: Int? = null,
    val homeTeamName: String? = null,
    val awayTeamName:String? = null



): Parcelable
