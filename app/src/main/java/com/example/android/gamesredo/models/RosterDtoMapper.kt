package com.example.android.gamesredo.models

import com.example.android.gamesredo.Roster
import com.example.android.gamesredo.domain.RosterModel
import com.example.android.gamesredo.network.util.DomainMapper

class RosterDtoMapper: DomainMapper<Roster, RosterModel> {

    override fun mapToDomainModel(model: Roster): RosterModel {
        return RosterModel(
            person = model.person,
            jerseyNumber = model.jerseyNumber,
            parentTeamId = model.parentTeamId,
            playerStatus = model.playerStatus,
            position = model.position,

        )
    }

     fun toDomainList(initial: List<Roster>): List<RosterModel> {
        return initial.map { mapToDomainModel(it) }
    }

}