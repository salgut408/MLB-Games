package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Roster (

  @SerializedName("person"       ) var person       : Person?   = Person(),
  @SerializedName("jerseyNumber" ) var jerseyNumber : String?   = null,
  @SerializedName("position"     ) var position     : Position? = Position(),
  @SerializedName("status"       ) var playerStatus       : PlayerStatus?   = PlayerStatus(),
  @SerializedName("parentTeamId" ) var parentTeamId : Int?      = null

)