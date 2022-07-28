package com.example.android.gamesredo.network.util

import com.example.android.gamesredo.TeamRecords
import com.example.android.gamesredo.domain.StandingsModel

interface DomainMapper <T, DomainModel> {

    fun mapToDomainModel(model: T): DomainModel

//    fun mapFromDomainModel(domainModel: DomainModel): T

//    fun toDomainList(initial: List<T>): List<DomainModel>{
//        return initial.map { mapToDomainModel(it) }
//    }



}