package com.example.android.gamesredo.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Teams2 (

    @SerializedName("home" ) var home2 : Home2? = Home2(),
    @SerializedName("away" ) var away2 : Away2? = Away2()

): Parcelable