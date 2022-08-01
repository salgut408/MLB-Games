package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class TeamsHist (

  @SerializedName("allStarStatus"   ) var allStarStatus   : String?  = null,
  @SerializedName("id"              ) var id              : Int?     = null,
  @SerializedName("name"            ) var name            : String?  = null,
  @SerializedName("link"            ) var link            : String?  = null,
  @SerializedName("season"          ) var season          : Int?     = null,
  @SerializedName("venue"           ) var venue           : Venue?   = Venue(),
  @SerializedName("teamCode"        ) var teamCode        : String?  = null,
  @SerializedName("fileCode"        ) var fileCode        : String?  = null,
  @SerializedName("abbreviation"    ) var abbreviation    : String?  = null,
  @SerializedName("teamName"        ) var teamName        : String?  = null,
  @SerializedName("locationName"    ) var locationName    : String?  = null,
  @SerializedName("firstYearOfPlay" ) var firstYearOfPlay : String?  = null,
  @SerializedName("league"          ) var league          : League?  = League(),
  @SerializedName("sport"           ) var sport           : Sport?   = Sport(),
  @SerializedName("shortName"       ) var shortName       : String?  = null,
  @SerializedName("franchiseName"   ) var franchiseName   : String?  = null,
  @SerializedName("clubName"        ) var clubName        : String?  = null,
  @SerializedName("active"          ) var active          : Boolean? = null

)