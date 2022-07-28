package com.example.android.gamesredo.domain

import android.os.Parcelable
import com.example.android.gamesredo.Person
import com.example.android.gamesredo.PlayerStatus
import com.example.android.gamesredo.Position
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class RosterModel (

    @SerializedName("person"       ) var person       : Person?   = Person(),
    @SerializedName("jerseyNumber" ) var jerseyNumber : String?   = null,
    @SerializedName("position"     ) var position     : Position? = Position(),
    @SerializedName("status"       ) var playerStatus       : PlayerStatus?   = PlayerStatus(),
    @SerializedName("parentTeamId" ) var parentTeamId : Int?      = null

): Parcelable
