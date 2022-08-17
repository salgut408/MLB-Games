package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class AllTeamsResponse (

  @SerializedName("copyright" ) var copyright : String?          = null,
  @SerializedName("teams"     ) var allTeams     : ArrayList<AllTeam> = arrayListOf()

)