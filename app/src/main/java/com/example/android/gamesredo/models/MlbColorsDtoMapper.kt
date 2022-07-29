package com.example.android.gamesredo.models

import com.example.android.gamesredo.MlbColorResponse
import com.example.android.gamesredo.MlbColors
import com.example.android.gamesredo.domain.MlbColorsModel
import com.example.android.gamesredo.network.util.DomainMapper

class MlbColorsDtoMapper: DomainMapper<MlbColors, MlbColorsModel> {
    override fun mapToDomainModel(model: MlbColors): MlbColorsModel {
        return MlbColorsModel(
            colors = model.colors,
            logo = model.logo,
            name = model.name
        )
    }

    fun toDomainList(initial: List<MlbColors>): List<MlbColorsModel>{
        return initial.map { mapToDomainModel(it) }
    }
}