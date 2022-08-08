package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result (

  @SerializedName("type"        ) var type        : String? = null,
  @SerializedName("event"       ) var event       : String? = null,
  @SerializedName("eventType"   ) var eventType   : String? = null,
  @SerializedName("description" ) var description : String? = null,
  @SerializedName("rbi"         ) var rbi         : Int?    = null,
  @SerializedName("awayScore"   ) var awayScore   : Int?    = null,
  @SerializedName("homeScore"   ) var homeScore   : Int?    = null

): Parcelable