package com.example.android.gamesredo.domain

import com.example.android.gamesredo.*
import com.example.android.gamesredo.models.contentresponspkg.Highlights2
import com.google.gson.annotations.SerializedName

data class ContentDetailModel(
    var highlights : Highlights2? = Highlights2(),
    var img: String? = null
) {
}