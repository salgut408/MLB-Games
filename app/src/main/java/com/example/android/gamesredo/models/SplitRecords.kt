package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SplitRecords (

  @SerializedName("wins"   ) var wins   : Int?    = null,
  @SerializedName("losses" ) var losses : Int?    = null,
  @SerializedName("type"   ) var type   : String? = null,
  @SerializedName("pct"    ) var pct    : String? = null

): Parcelable