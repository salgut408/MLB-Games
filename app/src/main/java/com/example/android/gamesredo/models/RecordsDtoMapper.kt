package com.example.android.gamesredo.models

import com.example.android.gamesredo.Records
import com.example.android.gamesredo.domain.RecordsModel
import com.example.android.gamesredo.network.util.DomainMapper

class RecordsDtoMapper : DomainMapper<Records, RecordsModel> {
    override fun mapToDomainModel(model: Records): RecordsModel {
        return RecordsModel(
            division = model.division,
            lastUpdated = model.lastUpdated,
            league = model.league,
            sport = model.sport,
            standingsType = model.standingsType,
            teamRecords = model.teamRecords
        )
    }

}