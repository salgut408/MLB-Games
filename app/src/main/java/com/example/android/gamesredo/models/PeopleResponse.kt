package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class PeopleResponse (

  @SerializedName("copyright" ) var copyright : String?           = null,
  @SerializedName("people"    ) var people    : ArrayList<People> = arrayListOf()

)