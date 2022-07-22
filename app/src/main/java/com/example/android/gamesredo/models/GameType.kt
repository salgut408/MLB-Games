package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class GameType (

    @SerializedName("id"          ) var id          : String? = null,
    @SerializedName("description" ) var description : String? = null

)