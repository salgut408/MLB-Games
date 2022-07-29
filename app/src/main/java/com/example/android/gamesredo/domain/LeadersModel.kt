package com.example.android.gamesredo.domain

import android.os.Parcelable
import com.example.android.gamesredo.*
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeadersModel(
    val rank     : Int?    = null,
    val value    : String? = null,
    val team     : Team?   = Team(),
    val league   : League? = League(),
    val person   : Person? = Person(),
    val sport    : SportDto?  = SportDto(),
    val season   : String? = null,
    val numTeams : Int?    = null
): Parcelable
