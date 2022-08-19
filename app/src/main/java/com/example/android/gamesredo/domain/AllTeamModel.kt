package com.example.android.gamesredo.domain

import android.os.Parcelable
import com.example.android.gamesredo.DivisionTeam
import com.example.android.gamesredo.LeagueTeam
import com.example.android.gamesredo.SportTeam
import com.example.android.gamesredo.VenueTeams
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AllTeamModel(
   var id              : Int?      = null,
    var name            : String?   = null,
     var link            : String?   = null,
    var season          : Int?      = null,
    var venue           : VenueTeams?    = VenueTeams(),
    var teamCode        : String?   = null,
     var fileCode        : String?   = null,
    var abbreviation    : String?   = null,
   var teamName        : String?   = null,
    var locationName    : String?   = null,
     var firstYearOfPlay : String?   = null,
     var league          : LeagueTeam?   = LeagueTeam(),
     var division        : DivisionTeam? = DivisionTeam(),
     var shortName       : String?   = null,
    var parentOrgName   : String?   = null,
     var parentOrgId     : Int?      = null,
     var franchiseName   : String?   = null,
     var clubName        : String?   = null,
    var active          : Boolean?  = null

): Parcelable
