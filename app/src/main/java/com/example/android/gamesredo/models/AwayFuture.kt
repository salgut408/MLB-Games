package com.example.android.gamesredo.models

import android.os.Parcelable
import com.example.android.gamesredo.LeagueRecord
import com.example.android.gamesredo.Team
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AwayFuture (

  @SerializedName("leagueRecord"    ) var leagueRecord    : LeagueRecord?    = LeagueRecord(),
  @SerializedName("score"           ) var score           : Int?             = null,
  @SerializedName("team"            ) var team            : Team?            = Team(),
  @SerializedName("isWinner"        ) var isWinner        : Boolean?         = null,
  @SerializedName("probablePitcher" ) var probablePitcherFuture : ProbablePitcherFuture? = ProbablePitcherFuture(),
  @SerializedName("splitSquad"      ) var splitSquad      : Boolean?         = null,
  @SerializedName("seriesNumber"    ) var seriesNumber    : Int?             = null

): Parcelable