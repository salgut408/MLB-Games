package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Person (

  @SerializedName("id"       ) var id       : Int?    = null,
  @SerializedName("fullName" ) var fullName : String? = null,
  @SerializedName("link"     ) var link     : String? = null

)