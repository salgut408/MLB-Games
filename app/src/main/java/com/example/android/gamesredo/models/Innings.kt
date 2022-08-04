package com.example.android.gamesredo.models

import com.example.android.gamesredo.Away
import com.example.android.gamesredo.Home
import com.google.gson.annotations.SerializedName


data class Innings (

  @SerializedName("num"        ) var num        : Int?    = null,
  @SerializedName("ordinalNum" ) var ordinalNum : String? = null,
  @SerializedName("home"       ) var home       : Home?   = Home(),
  @SerializedName("away"       ) var away       : Away?   = Away()

)