package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Playbacks (

  @SerializedName("name"   ) var name   : String? = null,
  @SerializedName("url"    ) var url    : String? = null,
  @SerializedName("width"  ) var width  : String? = null,
  @SerializedName("height" ) var height : String? = null

)