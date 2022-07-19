package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamRecords (

  @SerializedName("team"                      ) var team                      : Team?         = Team(),
  @SerializedName("season"                    ) var season                    : String?       = null,
  @SerializedName("streak"                    ) var streak                    : Streak?       = Streak(),
  @SerializedName("divisionRank"              ) var divisionRank              : String?       = null,
  @SerializedName("leagueRank"                ) var leagueRank                : String?       = null,
  @SerializedName("sportRank"                 ) var sportRank                 : String?       = null,
  @SerializedName("gamesPlayed"               ) var gamesPlayed               : Int?          = null,
  @SerializedName("gamesBack"                 ) var gamesBack                 : String?       = null,
  @SerializedName("wildCardGamesBack"         ) var wildCardGamesBack         : String?       = null,
  @SerializedName("leagueGamesBack"           ) var leagueGamesBack           : String?       = null,
  @SerializedName("springLeagueGamesBack"     ) var springLeagueGamesBack     : String?       = null,
  @SerializedName("sportGamesBack"            ) var sportGamesBack            : String?       = null,
  @SerializedName("divisionGamesBack"         ) var divisionGamesBack         : String?       = null,
  @SerializedName("conferenceGamesBack"       ) var conferenceGamesBack       : String?       = null,
  @SerializedName("leagueRecord"              ) var leagueRecord              : LeagueRecord? = LeagueRecord(),
  @SerializedName("lastUpdated"               ) var lastUpdated               : String?       = null,
  @SerializedName("records"                   ) var records                   : Records?      = Records(),
  @SerializedName("runsAllowed"               ) var runsAllowed               : Int?          = null,
  @SerializedName("runsScored"                ) var runsScored                : Int?          = null,
  @SerializedName("divisionChamp"             ) var divisionChamp             : Boolean?      = null,
  @SerializedName("divisionLeader"            ) var divisionLeader            : Boolean?      = null,
  @SerializedName("hasWildcard"               ) var hasWildcard               : Boolean?      = null,
  @SerializedName("clinched"                  ) var clinched                  : Boolean?      = null,
  @SerializedName("eliminationNumber"         ) var eliminationNumber         : String?       = null,
  @SerializedName("wildCardEliminationNumber" ) var wildCardEliminationNumber : String?       = null,
  @SerializedName("magicNumber"               ) var magicNumber               : String?       = null,
  @SerializedName("wins"                      ) var wins                      : Int?          = null,
  @SerializedName("losses"                    ) var losses                    : Int?          = null,
  @SerializedName("runDifferential"           ) var runDifferential           : Int?          = null,
  @SerializedName("winningPercentage"         ) var winningPercentage         : String?       = null

): Parcelable