package com.example.android.gamesredo.db.todaysgamesdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodaysGamesDao {
    @Query("SELECT * FROM games_dataBase")
    fun getAllGamesInDb(): LiveData<List<GamesDatabaseObj>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(games: List<GamesDatabaseObj>)
}