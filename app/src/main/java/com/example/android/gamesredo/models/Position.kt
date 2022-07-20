package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Position (

  @SerializedName("code"         ) var code         : String? = null,
  @SerializedName("name"         ) var name         : String? = null,
  @SerializedName("type"         ) var type         : String? = null,
  @SerializedName("abbreviation" ) var abbreviation : String? = null

)