package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("link" ) var link : String? = null

): Parcelable