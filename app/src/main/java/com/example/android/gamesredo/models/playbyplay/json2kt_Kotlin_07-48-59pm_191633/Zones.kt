package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Zones (

  @SerializedName("zone"  ) var zone  : String? = null,
  @SerializedName("color" ) var color : String? = null,
  @SerializedName("temp"  ) var temp  : String? = null,
  @SerializedName("value" ) var value : String? = null

): Parcelable