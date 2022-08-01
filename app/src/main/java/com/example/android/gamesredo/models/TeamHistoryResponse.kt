package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class TeamHistoryResponse (

  @SerializedName("copyright" ) var copyright : String?          = null,
  @SerializedName("teams"     ) var teamsHist     : ArrayList<TeamsHist> = arrayListOf()

)