package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Teams (

  @SerializedName("away" ) var away : Away? = Away(),
  @SerializedName("home" ) var home : Home? = Home()

): Parcelable