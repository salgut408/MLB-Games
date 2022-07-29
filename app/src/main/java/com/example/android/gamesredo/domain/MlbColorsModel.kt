package com.example.android.gamesredo.domain

import android.os.Parcelable
import com.example.android.gamesredo.Colors
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MlbColorsModel(

    val logo   : String? = null,
    val name   : String? = null,
    val colors : Colors? = Colors()

): Parcelable
