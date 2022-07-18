package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class LeagueRecords (

  @SerializedName("wins"   ) var wins   : Int?    = null,
  @SerializedName("losses" ) var losses : Int?    = null,
  @SerializedName("pct"    ) var pct    : String? = null,
  @SerializedName("league" ) var league : League? = League()

)