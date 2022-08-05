package com.example.android.gamesredo.models

import com.example.android.gamesredo.domain.GamePredictionModel
import com.example.android.gamesredo.network.util.DomainMapper

class GamePredictionDtoMapper: DomainMapper<GamePredictionResponse, GamePredictionModel> {
    override fun mapToDomainModel(model: GamePredictionResponse): GamePredictionModel {
        return GamePredictionModel(
            awayWinProbability = model.awayWinProbability?.toInt(),
            centerFieldSacFlyProbabilityFuture = model.centerFieldSacFlyProbabilityFuture,
            game = model.game,
            homeWinProbability = model.homeWinProbability?.toInt(),
            leftFieldSacFlyProbability = model.leftFieldSacFlyProbability,
            rightFieldSacFlyProbabilityFuture = model.rightFieldSacFlyProbabilityFuture,
            homeTeamFromPredictionsResp = model.game?.teamsFuture?.homeFuture,
            awayTeamFromPredictionsResp = model.game?.teamsFuture?.awayFuture,
            gamePk = model.game?.gamePk

        )
    }
}