package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayByPlayResponse (

  @SerializedName("copyright"     ) var copyright     : String?                  = null,
  @SerializedName("allPlays"      ) var allPlays      : ArrayList<AllPlays>      = arrayListOf(),
  @SerializedName("currentPlay"   ) var currentPlay   : CurrentPlay?             = CurrentPlay(),
  @SerializedName("scoringPlays"  ) var scoringPlays  : ArrayList<Int>           = arrayListOf(),
  @SerializedName("playsByInning" ) var playsByInning : ArrayList<PlaysByInning> = arrayListOf()

): Parcelable