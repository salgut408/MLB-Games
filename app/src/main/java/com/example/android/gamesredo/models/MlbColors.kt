package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MlbColors (

  @SerializedName("logo"   ) var logo   : String? = null,
  @SerializedName("name"   ) var name   : String? = null,
  @SerializedName("colors" ) var colors : Colors? = Colors()

): Parcelable