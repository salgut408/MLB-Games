package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class TeamRosterResponse (

  @SerializedName("copyright"  ) var copyright  : String?           = null,
  @SerializedName("roster"     ) var roster     : ArrayList<Roster> = arrayListOf(),
  @SerializedName("link"       ) var link       : String?           = null,
  @SerializedName("teamId"     ) var teamId     : Int?              = null,
  @SerializedName("rosterType" ) var rosterType : String?           = null

)