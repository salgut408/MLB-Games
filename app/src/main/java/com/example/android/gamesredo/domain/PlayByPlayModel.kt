package com.example.android.gamesredo.domain

import android.os.Parcelable
import com.example.android.gamesredo.*
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayByPlayModel(
//    val allPlays      : ArrayList<AllPlays>      = arrayListOf(),
    val result      : Result?               = Result(),
    val desc       : String?                = null,

    val runners     : ArrayList<Runners>    = arrayListOf(),
    val playEvents  : ArrayList<PlayEvents> = arrayListOf(),


): Parcelable {
}