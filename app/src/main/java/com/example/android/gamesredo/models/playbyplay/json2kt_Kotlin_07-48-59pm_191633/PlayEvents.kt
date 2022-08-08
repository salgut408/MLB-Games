package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayEvents (

  @SerializedName("details"   ) var details   : Details? = Details(),
  @SerializedName("count"     ) var count     : Count?   = Count(),
  @SerializedName("index"     ) var index     : Int?     = null,
  @SerializedName("startTime" ) var startTime : String?  = null,
  @SerializedName("endTime"   ) var endTime   : String?  = null,
  @SerializedName("isPitch"   ) var isPitch   : Boolean? = null,
  @SerializedName("type"      ) var type      : String?  = null,
  @SerializedName("player"    ) var player    : Player?  = Player()

): Parcelable