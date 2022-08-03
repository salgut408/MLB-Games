package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Away (

  @SerializedName("leagueRecord" ) var leagueRecord : LeagueRecord? = LeagueRecord(),
  @SerializedName("score"        ) var score        : Int?          = null,
  @SerializedName("team"         ) var team         : Team?         = Team(),
  @SerializedName("splitSquad"   ) var splitSquad   : Boolean?      = null,
  @SerializedName("seriesNumber" ) var seriesNumber : Int?          = null,
  @SerializedName("isWinner"     ) var isWinner     : Boolean?      = null,

): Parcelable