package com.example.android.gamesredo.models

import com.example.android.gamesredo.Leaders
import com.example.android.gamesredo.domain.LeadersModel
import com.example.android.gamesredo.network.util.DomainMapper

class LeadersDtoMapper: DomainMapper<Leaders, LeadersModel> {
    override fun mapToDomainModel(model: Leaders): LeadersModel {
        return LeadersModel(
            league = model.league,
            numTeams = model.numTeams,
            person = model.person,
            rank = model.rank,
            season = model.season,
            sport = model.sport,
            team = model.team,
            value = model.value
        )
    }
    fun toDomainList(initial: List<Leaders>): List<LeadersModel>{
        return initial.map { mapToDomainModel(it) }
    }
}