package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class AllTeam (

  @SerializedName("allStarStatus"   ) var allStarStatus   : String?   = null,
  @SerializedName("id"              ) var id              : Int?      = null,
  @SerializedName("name"            ) var name            : String?   = null,
  @SerializedName("link"            ) var link            : String?   = null,
  @SerializedName("season"          ) var season          : Int?      = null,
  @SerializedName("venue"           ) var venue           : VenueTeams?    = VenueTeams(),
  @SerializedName("teamCode"        ) var teamCode        : String?   = null,
  @SerializedName("fileCode"        ) var fileCode        : String?   = null,
  @SerializedName("abbreviation"    ) var abbreviation    : String?   = null,
  @SerializedName("teamName"        ) var teamName        : String?   = null,
  @SerializedName("locationName"    ) var locationName    : String?   = null,
  @SerializedName("firstYearOfPlay" ) var firstYearOfPlay : String?   = null,
  @SerializedName("league"          ) var league          : LeagueTeam?   = LeagueTeam(),
  @SerializedName("division"        ) var division        : DivisionTeam? = DivisionTeam(),
  @SerializedName("sport"           ) var sport           : SportTeam?    = SportTeam(),
  @SerializedName("shortName"       ) var shortName       : String?   = null,
  @SerializedName("parentOrgName"   ) var parentOrgName   : String?   = null,
  @SerializedName("parentOrgId"     ) var parentOrgId     : Int?      = null,
  @SerializedName("franchiseName"   ) var franchiseName   : String?   = null,
  @SerializedName("clubName"        ) var clubName        : String?   = null,
  @SerializedName("active"          ) var active          : Boolean?  = null

)