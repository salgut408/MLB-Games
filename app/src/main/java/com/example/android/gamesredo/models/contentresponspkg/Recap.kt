package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Recap (

  @SerializedName("mlb" ) var mlb : Mlb? = Mlb()

)