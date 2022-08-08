package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movement (

  @SerializedName("originBase" ) var originBase : String?  = null,
  @SerializedName("start"      ) var start      : String?  = null,
  @SerializedName("end"        ) var end        : String?  = null,
  @SerializedName("outBase"    ) var outBase    : String?  = null,
  @SerializedName("isOut"      ) var isOut      : Boolean? = null,
  @SerializedName("outNumber"  ) var outNumber  : Int?     = null

): Parcelable