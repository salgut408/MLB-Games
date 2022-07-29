package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Colors (

  @SerializedName("primary"   ) var primary   : String? = null,
  @SerializedName("secondary" ) var secondary : String? = null

): Parcelable