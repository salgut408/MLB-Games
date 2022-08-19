package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SportTeam (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("link" ) var link : String? = null,
  @SerializedName("name" ) var name : String? = null

): Parcelable