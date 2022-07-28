package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PrimaryPosition (

  @SerializedName("code"         ) var code         : String? = null,
  @SerializedName("name"         ) var name         : String? = null,
  @SerializedName("type"         ) var type         : String? = null,
  @SerializedName("abbreviation" ) var abbreviation : String? = null

): Parcelable