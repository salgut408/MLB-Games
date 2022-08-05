package com.example.android.gamesredo.models

import android.os.Parcelable
import com.example.android.gamesredo.Team
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Offense (

  @SerializedName("batter"       ) var batter2       : Batter2?  = Batter2(),
  @SerializedName("onDeck"       ) var onDeck       : OnDeck?  = OnDeck(),
  @SerializedName("inHole"       ) var inHole       : InHole?  = InHole(),
  @SerializedName("first"        ) var first        : First?   = First(),
  @SerializedName("pitcher"      ) var pitcher2      : Pitcher2? = Pitcher2(),
  @SerializedName("battingOrder" ) var battingOrder : Int?     = null,
  @SerializedName("team"         ) var team         : Team?    = Team()

): Parcelable