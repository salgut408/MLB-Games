package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Type (

  @SerializedName("displayName" ) var displayName : String? = null

): Parcelable