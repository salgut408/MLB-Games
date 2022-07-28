package com.example.android.gamesredo.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SportModel (

   val id   : Int?    = null,
   val link : String? = null

): Parcelable