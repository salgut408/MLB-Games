package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class MlbColors (

  @SerializedName("logo"   ) var logo   : String? = null,
  @SerializedName("name"   ) var name   : String? = null,
  @SerializedName("colors" ) var colors : Colors? = Colors()

)