package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Runners (

  @SerializedName("movement" ) var movement : Movement?          = Movement(),
  @SerializedName("details"  ) var details  : Details?           = Details(),
  @SerializedName("credits"  ) var credits  : ArrayList<Credits> = arrayListOf()

): Parcelable