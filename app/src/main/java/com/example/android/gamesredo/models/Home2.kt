package com.example.android.gamesredo.models

import com.google.gson.annotations.SerializedName


data class Home2 (

  @SerializedName("runs"       ) var runs       : Int? = null,
  @SerializedName("hits"       ) var hits       : Int? = null,
  @SerializedName("errors"     ) var errors     : Int? = null,
  @SerializedName("leftOnBase" ) var leftOnBase : Int? = null

)