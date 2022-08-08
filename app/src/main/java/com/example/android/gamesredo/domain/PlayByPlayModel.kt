package com.example.android.gamesredo.domain

import android.os.Parcelable
import com.example.android.gamesredo.AllPlays
import com.example.android.gamesredo.CurrentPlay
import com.example.android.gamesredo.PlaysByInning
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PlayByPlayModel(
    val allPlays      : ArrayList<AllPlays>      = arrayListOf(),
    val currentPlay   : CurrentPlay?             = CurrentPlay(),


): Parcelable {
}