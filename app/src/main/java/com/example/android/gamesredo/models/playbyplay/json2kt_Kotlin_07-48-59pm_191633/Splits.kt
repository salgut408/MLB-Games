package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Splits (

  @SerializedName("batter"    ) var batter    : String? = null,
  @SerializedName("pitcher"   ) var pitcher   : String? = null,
  @SerializedName("menOnBase" ) var menOnBase : String? = null

): Parcelable