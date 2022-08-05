package com.example.android.gamesredo.models

import android.os.Parcelable
import com.example.android.gamesredo.Away
import com.example.android.gamesredo.Home
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamsFuture (

  @SerializedName("away" ) var awayFuture : AwayFuture? = AwayFuture(),
  @SerializedName("home" ) var homeFuture : HomeFuture? = HomeFuture()

): Parcelable