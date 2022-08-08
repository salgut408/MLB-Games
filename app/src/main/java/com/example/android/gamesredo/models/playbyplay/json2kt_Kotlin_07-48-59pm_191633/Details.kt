package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Details (

  @SerializedName("description"   ) var description   : String?  = null,
  @SerializedName("event"         ) var event         : String?  = null,
  @SerializedName("eventType"     ) var eventType     : String?  = null,
  @SerializedName("awayScore"     ) var awayScore     : Int?     = null,
  @SerializedName("homeScore"     ) var homeScore     : Int?     = null,
  @SerializedName("isScoringPlay" ) var isScoringPlay : Boolean? = null,
  @SerializedName("hasReview"     ) var hasReview     : Boolean? = null

): Parcelable