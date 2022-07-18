package com.example.android.gamesredo

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize


data class Games (
  @SerializedName("gamePk"                 ) var gamePk                 : Int?     = null,
  @SerializedName("link"                   ) var link                   : String?  = null,
  @SerializedName("gameType"               ) var gameType               : String?  = null,
  @SerializedName("season"                 ) var season                 : String?  = null,
  @SerializedName("gameDate"               ) var gameDate               : String?  = null,
  @SerializedName("officialDate"           ) var officialDate           : String?  = null,
  @SerializedName("status"                 ) var status                 : Status?  = Status(),
  @SerializedName("teams"                  ) var teams                  : Teams?   = Teams(),
  @SerializedName("venue"                  ) var venue                  : Venue?   = Venue(),
  @SerializedName("content"                ) var content                : Content? = Content(),
  @SerializedName("gameNumber"             ) var gameNumber             : Int?     = null,
  @SerializedName("publicFacing"           ) var publicFacing           : Boolean? = null,
  @SerializedName("doubleHeader"           ) var doubleHeader           : String?  = null,
  @SerializedName("gamedayType"            ) var gamedayType            : String?  = null,
  @SerializedName("tiebreaker"             ) var tiebreaker             : String?  = null,
  @SerializedName("calendarEventID"        ) var calendarEventID        : String?  = null,
  @SerializedName("seasonDisplay"          ) var seasonDisplay          : String?  = null,
  @SerializedName("dayNight"               ) var dayNight               : String?  = null,
  @SerializedName("scheduledInnings"       ) var scheduledInnings       : Int?     = null,
  @SerializedName("reverseHomeAwayStatus"  ) var reverseHomeAwayStatus  : Boolean? = null,
  @SerializedName("inningBreakLength"      ) var inningBreakLength      : Int?     = null,
  @SerializedName("gamesInSeries"          ) var gamesInSeries          : Int?     = null,
  @SerializedName("seriesGameNumber"       ) var seriesGameNumber       : Int?     = null,
  @SerializedName("seriesDescription"      ) var seriesDescription      : String?  = null,
  @SerializedName("recordSource"           ) var recordSource           : String?  = null,
  @SerializedName("ifNecessary"            ) var ifNecessary            : String?  = null,
  @SerializedName("ifNecessaryDescription" ) var ifNecessaryDescription : String?  = null

): Parcelable