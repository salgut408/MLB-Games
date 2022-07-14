package com.example.android.gamesredo.repository

import com.example.android.gamesredo.api.RetrofitInstance
import com.example.android.gamesredo.db.VenueDatabase

class GameRepository(
    val db: VenueDatabase
) {

suspend fun getGames(sportId: Int) =
    RetrofitInstance.api.getGames(1)

}