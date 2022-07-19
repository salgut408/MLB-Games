package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Streak (

  @SerializedName("streakType"   ) var streakType   : String? = null,
  @SerializedName("streakNumber" ) var streakNumber : Int?    = null,
  @SerializedName("streakCode"   ) var streakCode   : String? = null

): Parcelable