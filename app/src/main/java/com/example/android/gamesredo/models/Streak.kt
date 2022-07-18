package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Streak (

  @SerializedName("streakType"   ) var streakType   : String? = null,
  @SerializedName("streakNumber" ) var streakNumber : Int?    = null,
  @SerializedName("streakCode"   ) var streakCode   : String? = null

)