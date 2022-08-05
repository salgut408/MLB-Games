package com.example.android.gamesredo.models.contentresponspkg

import com.example.android.gamesredo.GameContentResponse
import com.example.android.gamesredo.domain.ContentDetailModel
import com.example.android.gamesredo.network.util.DomainMapper

class ContentResponseDtoMapper: DomainMapper<GameContentResponse, ContentDetailModel> {
    override fun mapToDomainModel(model: GameContentResponse): ContentDetailModel {
        return ContentDetailModel(
            highlights = model.highlights?.highlights2,
            img = model.highlights?.highlights2?.items!![0].image?.cuts!![0].src.toString()

        )
    }
}