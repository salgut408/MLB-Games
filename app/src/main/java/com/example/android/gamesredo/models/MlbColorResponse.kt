package com.example.android.gamesredo

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MlbColorResponse (

  @SerializedName("mlbColors" ) var mlbColors : ArrayList<MlbColors> = arrayListOf()

): Parcelable