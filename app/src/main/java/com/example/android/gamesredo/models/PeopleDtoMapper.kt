package com.example.android.gamesredo.models

import com.example.android.gamesredo.People
import com.example.android.gamesredo.domain.PeopleModel
import com.example.android.gamesredo.network.util.DomainMapper

class PeopleDtoMapper: DomainMapper<People, PeopleModel> {
    override fun mapToDomainModel(model: People): PeopleModel {
        return PeopleModel(
            active = model.active,
            batSide = model.batSide,
            birthCity = model.birthCity,
            birthCountry = model.birthCountry,
            birthStateProvince = model.birthStateProvince,
            boxscoreName = model.boxscoreName,
            currentAge = model.currentAge,
            draftYear = model.draftYear,
            firstLastName = model.firstLastName,
            firstName = model.firstName,
            fullName = model.fullName,
            gender = model.gender,
            height = model.height,
            id=model.id,
            initLastName = model.initLastName,
            isPlayer = model.isPlayer,
            isVerified = model.isVerified,
            lastFirstName = model.lastFirstName,
            lastInitName = model.lastInitName,
            lastName = model.lastName,
            link = model.link,
            middleName = model.middleName,
            mlbDebutDate = model.mlbDebutDate,
            nameFirstLast = model.nameFirstLast,
            nameSlug = model.nameSlug,
            pitchHand = model.pitchHand,
            primaryNumber = model.primaryNumber,
            strikeZoneBottom = model.strikeZoneBottom,
            strikeZoneTop = model.strikeZoneTop,
            useName = model.useName,
            weight = model.weight


        )
    }
    fun toDomainList(initial: List<People>): List<PeopleModel> {
        return initial.map { mapToDomainModel(it) }
    }

}