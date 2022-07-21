package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class BatSide (

  @SerializedName("code"        ) var code        : String? = null,
  @SerializedName("description" ) var description : String? = null

)