package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Image (

  @SerializedName("title"       ) var title       : String?         = null,
  @SerializedName("altText"     ) var altText     : String?         = null,
  @SerializedName("templateUrl" ) var templateUrl : String?         = null,
  @SerializedName("cuts"        ) var cuts        : ArrayList<Cuts> = arrayListOf()

)