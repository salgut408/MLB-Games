package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Teams (

  @SerializedName("away" ) var away : Away? = Away(),
  @SerializedName("home" ) var home : Home? = Home()

)