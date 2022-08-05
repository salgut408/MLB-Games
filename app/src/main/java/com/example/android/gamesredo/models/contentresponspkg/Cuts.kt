package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Cuts (

  @SerializedName("aspectRatio" ) var aspectRatio : String? = null,
  @SerializedName("width"       ) var width       : Int?    = null,
  @SerializedName("height"      ) var height      : Int?    = null,
  @SerializedName("src"         ) var src         : String? = null,
  @SerializedName("at2x"        ) var at2x        : String? = null,
  @SerializedName("at3x"        ) var at3x        : String? = null

)