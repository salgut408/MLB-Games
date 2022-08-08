package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Count (

  @SerializedName("balls"   ) var balls   : Int? = null,
  @SerializedName("strikes" ) var strikes : Int? = null,
  @SerializedName("outs"    ) var outs    : Int? = null

): Parcelable