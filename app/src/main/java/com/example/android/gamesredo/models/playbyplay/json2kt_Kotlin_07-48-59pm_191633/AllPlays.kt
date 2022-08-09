package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AllPlays (

  @SerializedName("result"      ) var result      : Result?               = Result(),
  @SerializedName("about"       ) var about       : About?                = About(),
  @SerializedName("count"       ) var count       : Count?                = Count(),
  @SerializedName("matchup"     ) var matchup     : Matchup?              = Matchup(),
  @SerializedName("pitchIndex"  ) var pitchIndex  : ArrayList<Int>        = arrayListOf(),
  @SerializedName("actionIndex" ) var actionIndex : String?               = null,
  @SerializedName("runnerIndex" ) var runnerIndex : ArrayList<Int>        = arrayListOf(),
  @SerializedName("runners"     ) var runners     : ArrayList<Runners>    = arrayListOf(),
  @SerializedName("playEvents"  ) var playEvents  : ArrayList<PlayEvents> = arrayListOf(),
  @SerializedName("playEndTime" ) var playEndTime : String?               = null,
  @SerializedName("atBatIndex"  ) var atBatIndex  : Int?                  = null

): Parcelable