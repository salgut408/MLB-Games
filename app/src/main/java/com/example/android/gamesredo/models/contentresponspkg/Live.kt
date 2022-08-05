package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Live (

  @SerializedName("items" ) var items : ArrayList<String> = arrayListOf()

)