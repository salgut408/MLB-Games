package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class League (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("link" ) var link : String? = null

)