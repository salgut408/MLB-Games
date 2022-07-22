package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class LeagueLeaders (

    @SerializedName("leaderCategory" ) var leaderCategory : String?            = null,
    @SerializedName("season"         ) var season         : String?            = null,
    @SerializedName("gameType"       ) var gameType       : GameType?          = GameType(),
    @SerializedName("leaders"        ) var leaders        : ArrayList<Leaders> = arrayListOf(),
    @SerializedName("statGroup"      ) var statGroup      : String?            = null,
    @SerializedName("totalSplits"    ) var totalSplits    : Int?               = null

)