package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Epg (

  @SerializedName("title" ) var title : String?          = null,
  @SerializedName("items" ) var items : ArrayList<Items> = arrayListOf()

)