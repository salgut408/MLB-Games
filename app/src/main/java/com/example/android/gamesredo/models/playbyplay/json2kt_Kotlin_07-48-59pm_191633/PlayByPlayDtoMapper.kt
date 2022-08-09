package com.example.android.gamesredo.models.playbyplay.json2kt_Kotlin_07

import com.example.android.gamesredo.PlayByPlayResponse
import com.example.android.gamesredo.domain.PlayByPlayModel
import com.example.android.gamesredo.models.GameDetailResponse
import com.example.android.gamesredo.network.util.DomainMapper


class PlayByPlayDtoMapper: DomainMapper <PlayByPlayResponse, PlayByPlayModel>  {
    override fun mapToDomainModel(model: PlayByPlayResponse): PlayByPlayModel {
        return PlayByPlayModel(
           result = model.currentPlay?.result,
            desc = model.currentPlay?.result?.description,

            playEvents = model.currentPlay?.playEvents ?: arrayListOf(),
            runners = model.currentPlay?.runners ?: arrayListOf(),



        )
    }
}