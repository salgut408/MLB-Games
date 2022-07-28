package com.example.android.gamesredo.domain

import android.os.Parcelable
import com.example.android.gamesredo.Person
import com.example.android.gamesredo.PlayerStatus
import com.example.android.gamesredo.Position
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class RosterModel (

    val person       : Person?   = Person(),
    val jerseyNumber : String?   = null,
    val position     : Position? = Position(),
    val playerStatus       : PlayerStatus?   = PlayerStatus(),
    val parentTeamId : Int?      = null

): Parcelable
