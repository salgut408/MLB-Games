package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class PitchHand (

  @SerializedName("code"        ) var code        : String? = null,
  @SerializedName("description" ) var description : String? = null

)