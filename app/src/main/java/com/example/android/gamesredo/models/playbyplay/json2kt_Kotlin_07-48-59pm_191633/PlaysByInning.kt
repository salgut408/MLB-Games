package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlaysByInning (

  @SerializedName("startIndex" ) var startIndex : Int?           = null,
  @SerializedName("endIndex"   ) var endIndex   : Int?           = null,
  @SerializedName("top"        ) var top        : String?        = null,
  @SerializedName("bottom"     ) var bottom     : ArrayList<Int> = arrayListOf(),
  @SerializedName("hits"       ) var hits       : Hits?          = Hits()

): Parcelable