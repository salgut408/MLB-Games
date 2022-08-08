package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stat (

  @SerializedName("name"  ) var name  : String?          = null,
  @SerializedName("zones" ) var zones : ArrayList<Zones> = arrayListOf()

): Parcelable