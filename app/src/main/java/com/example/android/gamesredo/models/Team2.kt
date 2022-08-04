package com.example.android.gamesredo.models

import com.google.gson.annotations.SerializedName


data class Team2 (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("link" ) var link : String? = null

)