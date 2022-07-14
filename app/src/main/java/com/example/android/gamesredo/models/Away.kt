package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Away (

  @SerializedName("leagueRecord" ) var leagueRecord : LeagueRecord? = LeagueRecord(),
  @SerializedName("score"        ) var score        : Int?          = null,
  @SerializedName("team"         ) var team         : Team?         = Team(),
  @SerializedName("splitSquad"   ) var splitSquad   : Boolean?      = null,
  @SerializedName("seriesNumber" ) var seriesNumber : Int?          = null

)