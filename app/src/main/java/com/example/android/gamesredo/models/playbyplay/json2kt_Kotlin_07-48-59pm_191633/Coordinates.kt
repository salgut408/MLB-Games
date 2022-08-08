package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coordinates (

  @SerializedName("x" ) var x : Double? = null,
  @SerializedName("y" ) var y : Double? = null

): Parcelable