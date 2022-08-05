package com.example.android.gamesredo.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameDetailResponse (

  @SerializedName("copyright"            ) var copyright            : String?            = null,
  @SerializedName("currentInning"        ) var currentInning        : Int?               = null,
  @SerializedName("currentInningOrdinal" ) var currentInningOrdinal : String?            = null,
  @SerializedName("inningState"          ) var inningState          : String?            = null,
  @SerializedName("inningHalf"           ) var inningHalf           : String?            = null,
  @SerializedName("isTopInning"          ) var isTopInning          : Boolean?           = null,
  @SerializedName("scheduledInnings"     ) var scheduledInnings     : Int?               = null,
  @SerializedName("innings"              ) var innings              : ArrayList<Innings> = arrayListOf(),
  @SerializedName("teams"                ) var teams2                : Teams2?             = Teams2(),
  @SerializedName("defense"              ) var defense              : Defense?           = Defense(),
  @SerializedName("offense"              ) var offense              : Offense?           = Offense(),
  @SerializedName("balls"                ) var balls                : Int?               = null,
  @SerializedName("strikes"              ) var strikes              : Int?               = null,
  @SerializedName("outs"                 ) var outs                 : Int?               = null

): Parcelable