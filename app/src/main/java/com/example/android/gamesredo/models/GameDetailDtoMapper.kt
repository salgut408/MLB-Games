package com.example.android.gamesredo.models

import com.example.android.gamesredo.domain.GameDetailModel
import com.example.android.gamesredo.network.util.DomainMapper

class GameDetailDtoMapper: DomainMapper<GameDetailResponse, GameDetailModel> {
    override fun mapToDomainModel(model: GameDetailResponse): GameDetailModel {
        return GameDetailModel(
            balls = model.balls,
            currentInning = model.currentInning,
            currentInningOrdinal = model.currentInningOrdinal,
            defense = model.defense,
            inningHalf = model.inningHalf,
            innings = model.innings,
            inningState = model.inningState,
            isTopInning = model.isTopInning,
            offense = model.offense,
            outs = model.outs,
            scheduledInnings = model.scheduledInnings,
            strikes = model.strikes,
            teams2 = model.teams2,
            homeScore = model.teams2?.home2?.runs,
            awaySCore = model.teams2?.away2?.runs

        )
    }
}