package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class SportTeam (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("link" ) var link : String? = null,
  @SerializedName("name" ) var name : String? = null

)