package com.example.android.gamesredo.models

import com.google.gson.annotations.SerializedName


data class GamePredictionResponse (

  @SerializedName("game"                         ) var game                         : Game?                         = Game(),
  @SerializedName("leftFieldSacFlyProbability"   ) var leftFieldSacFlyProbability   : LeftFieldSacFlyProbabilityFuture?   = LeftFieldSacFlyProbabilityFuture(),
  @SerializedName("centerFieldSacFlyProbability" ) var centerFieldSacFlyProbabilityFuture : CenterFieldSacFlyProbabilityFuture? = CenterFieldSacFlyProbabilityFuture(),
  @SerializedName("rightFieldSacFlyProbability"  ) var rightFieldSacFlyProbabilityFuture  : RightFieldSacFlyProbabilityFuture?  = RightFieldSacFlyProbabilityFuture(),
  @SerializedName("awayWinProbability"           ) var awayWinProbability           : Int?                          = null,
  @SerializedName("homeWinProbability"           ) var homeWinProbability           : Int?                          = null

)