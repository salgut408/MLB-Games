package com.example.android.gamesredo.models

import com.example.android.gamesredo.TeamsHist
import com.example.android.gamesredo.domain.TeamsHistModel
import com.example.android.gamesredo.network.util.DomainMapper

class TeamsHistDtoMapper: DomainMapper<TeamsHist, TeamsHistModel> {
    override fun mapToDomainModel(model: TeamsHist): TeamsHistModel {
        return TeamsHistModel(
            abbreviation = model.abbreviation,
            active = model.active,
            clubName = model.clubName,
            fileCode = model.fileCode,
            firstYearOfPlay = model.firstYearOfPlay,
            franchiseName = model.franchiseName,
            id = model.id,
            league = model.league,
            link = model.link,
            locationName = model.locationName,
            name = model.name,
            season = model.season,
            shortName = model.shortName,
            teamCode = model.teamCode,
            teamName = model.teamName,
            venue = model.venue
        )
    }
}