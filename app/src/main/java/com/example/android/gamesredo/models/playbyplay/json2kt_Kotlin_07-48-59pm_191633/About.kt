package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class About (

  @SerializedName("atBatIndex"       ) var atBatIndex       : Int?     = null,
  @SerializedName("halfInning"       ) var halfInning       : String?  = null,
  @SerializedName("isTopInning"      ) var isTopInning      : Boolean? = null,
  @SerializedName("inning"           ) var inning           : Int?     = null,
  @SerializedName("startTime"        ) var startTime        : String?  = null,
  @SerializedName("endTime"          ) var endTime          : String?  = null,
  @SerializedName("isComplete"       ) var isComplete       : Boolean? = null,
  @SerializedName("isScoringPlay"    ) var isScoringPlay    : Boolean? = null,
  @SerializedName("hasReview"        ) var hasReview        : Boolean? = null,
  @SerializedName("hasOut"           ) var hasOut           : Boolean? = null,
  @SerializedName("captivatingIndex" ) var captivatingIndex : Int?     = null

): Parcelable