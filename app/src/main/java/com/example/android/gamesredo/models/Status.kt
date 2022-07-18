package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Status (

  @SerializedName("abstractGameState" ) var abstractGameState : String?  = null,
  @SerializedName("codedGameState"    ) var codedGameState    : String?  = null,
  @SerializedName("detailedState"     ) var detailedState     : String?  = null,
  @SerializedName("statusCode"        ) var statusCode        : String?  = null,
  @SerializedName("startTimeTBD"      ) var startTimeTBD      : Boolean? = null,
  @SerializedName("abstractGameCode"  ) var abstractGameCode  : String?  = null

): Parcelable