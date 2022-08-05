package com.example.android.gamesredo.models.contentresponspkg

import com.example.android.gamesredo.Items
import com.example.android.gamesredo.Live
import com.example.android.gamesredo.ScoreboardPreview
import com.google.gson.annotations.SerializedName

data class Highlights2 (

    @SerializedName("items" ) var items : ArrayList<Items> = arrayListOf()


)