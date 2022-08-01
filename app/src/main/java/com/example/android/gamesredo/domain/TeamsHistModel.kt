package com.example.android.gamesredo.domain

import com.example.android.gamesredo.League
import com.example.android.gamesredo.Sport
import com.example.android.gamesredo.Venue
import com.google.gson.annotations.SerializedName

data class TeamsHistModel (
    val id              : Int?     = null,
    val name            : String?  = null,
    val link            : String?  = null,
    val season          : Int?     = null,
    val venue           : Venue?   = Venue(),
    val teamCode        : String?  = null,
    val fileCode        : String?  = null,
    val abbreviation    : String?  = null,
    val teamName        : String?  = null,
    val locationName    : String?  = null,
    val firstYearOfPlay : String?  = null,
    val league          : League?  = League(),
    val shortName       : String?  = null,
    val franchiseName   : String?  = null,
    val clubName        : String?  = null,
    val active          : Boolean? = null

)