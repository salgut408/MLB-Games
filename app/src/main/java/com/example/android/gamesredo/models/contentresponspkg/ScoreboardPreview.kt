package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class ScoreboardPreview (

  @SerializedName("items" ) var items : ArrayList<String> = arrayListOf()

)