package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Sport (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("link" ) var link : String? = null

)