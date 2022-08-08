package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Credits (

  @SerializedName("player"   ) var player   : Player?   = Player(),
  @SerializedName("position" ) var position : PositionPlayByPlay? = PositionPlayByPlay(),
  @SerializedName("credit"   ) var credit   : String?   = null

): Parcelable