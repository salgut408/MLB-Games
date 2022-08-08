package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hits (

  @SerializedName("away" ) var away : ArrayList<AwayPlayByPlay> = arrayListOf(),
  @SerializedName("home" ) var home : ArrayList<HomePlayByPlay> = arrayListOf()

): Parcelable