package com.example.android.gamesredo.models.allteamslistresponse.json2kt_Kotlin_06

import com.example.android.gamesredo.AllTeam
import com.example.android.gamesredo.AllTeamsResponse
import com.example.android.gamesredo.domain.AllTeamModel
import com.example.android.gamesredo.network.util.DomainMapper


class AllTeamDtoMApper: DomainMapper<AllTeam, AllTeamModel> {
    override fun mapToDomainModel(model: AllTeam): AllTeamModel {
        return AllTeamModel(
            abbreviation = model.abbreviation,
            active = model.active,
            clubName = model.clubName,
            division = model.division,
            fileCode = model.fileCode,
            firstYearOfPlay = model.firstYearOfPlay,
            franchiseName = model.franchiseName,
            id = model.id,
            league = model.league,
            link = model.link,
            parentOrgId = model.parentOrgId,
            season = model.season,
            shortName = model.shortName,
            teamName = model.teamName,
            teamCode = model.teamCode,
                venue = model.venue,
        )
    }

    fun toDomainList(initial: List<AllTeam>): List<AllTeamModel> {
        return initial.map { mapToDomainModel(it) }
    }


}