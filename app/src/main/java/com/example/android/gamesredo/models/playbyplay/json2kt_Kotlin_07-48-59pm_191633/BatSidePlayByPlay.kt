package com.example.android.gamesredo

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BatSidePlayByPlay (

  @SerializedName("code"        ) var code        : String? = null,
  @SerializedName("description" ) var description : String? = null

): Parcelable