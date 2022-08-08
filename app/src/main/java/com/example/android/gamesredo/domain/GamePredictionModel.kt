package com.example.android.gamesredo.domain

import android.os.Parcelable
import com.example.android.gamesredo.models.*
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GamePredictionModel (
    val game                         : Game?                         = Game(),
    val leftFieldSacFlyProbability   : LeftFieldSacFlyProbabilityFuture?   = LeftFieldSacFlyProbabilityFuture(),
    val centerFieldSacFlyProbabilityFuture : CenterFieldSacFlyProbabilityFuture? = CenterFieldSacFlyProbabilityFuture(),
    val rightFieldSacFlyProbabilityFuture  : RightFieldSacFlyProbabilityFuture?  = RightFieldSacFlyProbabilityFuture(),
    val awayWinProbability           : Int?                          = null,
    val homeWinProbability           : Int?                          = null,
    val homeTeamFromPredictionsResp: HomeFuture? = HomeFuture(),
    val awayTeamFromPredictionsResp: AwayFuture? = AwayFuture(),
    val gamePk: Int? = null

): Parcelable