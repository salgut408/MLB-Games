package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class LeagueLeadersResponse (

    @SerializedName("copyright"     ) var copyright     : String?                  = null,
    @SerializedName("leagueLeaders" ) var leagueLeaders : ArrayList<LeagueLeaders> = arrayListOf()

)