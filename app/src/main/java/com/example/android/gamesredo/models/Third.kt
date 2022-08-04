package com.example.android.gamesredo.models

import com.google.gson.annotations.SerializedName


data class Third (

  @SerializedName("id"       ) var id       : Int?    = null,
  @SerializedName("fullName" ) var fullName : String? = null,
  @SerializedName("link"     ) var link     : String? = null

)