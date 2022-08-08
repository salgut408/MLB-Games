package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stats (

  @SerializedName("type"       ) var type       : Type?             = Type(),
  @SerializedName("group"      ) var group      : Group?            = Group(),
  @SerializedName("exemptions" ) var exemptions : ArrayList<String> = arrayListOf(),
  @SerializedName("splits"     ) var splits     : ArrayList<Splits> = arrayListOf()

): Parcelable