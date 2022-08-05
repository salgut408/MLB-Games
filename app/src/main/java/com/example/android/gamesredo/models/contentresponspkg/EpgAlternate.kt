package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class EpgAlternate (

  @SerializedName("items" ) var items : ArrayList<Items> = arrayListOf(),
  @SerializedName("title" ) var title : String?          = null

)