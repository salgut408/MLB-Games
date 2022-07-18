package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class AmericanLeagueStandingResponse (

  @SerializedName("copyright" ) var copyright : String?            = null,
  @SerializedName("records"   ) var records   : ArrayList<Records> = arrayListOf()

)