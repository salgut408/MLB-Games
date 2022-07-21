package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Colors (

  @SerializedName("primary"   ) var primary   : String? = null,
  @SerializedName("secondary" ) var secondary : String? = null

)