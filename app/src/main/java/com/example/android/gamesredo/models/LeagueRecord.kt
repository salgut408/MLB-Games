package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueRecord (

  @SerializedName("wins"   ) var wins   : Int?    = null,
  @SerializedName("losses" ) var losses : Int?    = null,
  @SerializedName("ties"   ) var ties   : Int?    = null,
  @SerializedName("pct"    ) var pct    : String? = null

): Parcelable {

//  override fun toString(): String {
//    return wins.toString() +" - " + losses.toString() +" " + pct.toString()
//  }
}

