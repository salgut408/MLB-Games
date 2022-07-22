package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Leaders (

    @SerializedName("rank"     ) var rank     : Int?    = null,
    @SerializedName("value"    ) var value    : String? = null,
    @SerializedName("team"     ) var team     : Team?   = Team(),
    @SerializedName("league"   ) var league   : League? = League(),
    @SerializedName("person"   ) var person   : Person? = Person(),
    @SerializedName("sport"    ) var sport    : Sport?  = Sport(),
    @SerializedName("season"   ) var season   : String? = null,
    @SerializedName("numTeams" ) var numTeams : Int?    = null

)