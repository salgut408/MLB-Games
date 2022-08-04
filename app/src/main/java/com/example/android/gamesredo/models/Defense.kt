package com.example.android.gamesredo.models

import com.example.android.gamesredo.Team
import com.google.gson.annotations.SerializedName


data class Defense (

  @SerializedName("pitcher"      ) var pitcher2      : Pitcher2?   = Pitcher2(),
  @SerializedName("catcher"      ) var catcher2      : Catcher2?   = Catcher2(),
  @SerializedName("first"        ) var first        : First?     = First(),
  @SerializedName("second"       ) var second       : Second?    = Second(),
  @SerializedName("third"        ) var third        : Third?     = Third(),
  @SerializedName("shortstop"    ) var shortstop    : Shortstop? = Shortstop(),
  @SerializedName("left"         ) var left         : Left?      = Left(),
  @SerializedName("center"       ) var center       : Center?    = Center(),
  @SerializedName("right"        ) var right        : Right?     = Right(),
  @SerializedName("batter"       ) var batter2       : Batter2?    = Batter2(),
  @SerializedName("onDeck"       ) var onDeck       : OnDeck?    = OnDeck(),
  @SerializedName("inHole"       ) var inHole       : InHole?    = InHole(),
  @SerializedName("battingOrder" ) var battingOrder : Int?       = null,
  @SerializedName("team"         ) var team         : Team?      = Team()

)