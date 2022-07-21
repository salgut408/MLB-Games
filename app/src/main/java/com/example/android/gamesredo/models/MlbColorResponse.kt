package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class MlbColorResponse (

  @SerializedName("mlbColors" ) var mlbColors : ArrayList<MlbColors> = arrayListOf()

)