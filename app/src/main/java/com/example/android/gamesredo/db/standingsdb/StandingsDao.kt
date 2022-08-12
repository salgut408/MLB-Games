package com.example.android.gamesredo.db.standingsdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StandingsDao {
    @Query("SELECT * FROM standings_database" )
    fun getAllStandingsinDb(): LiveData<List<StandingsDatabaseObj>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(standings: List<StandingsDatabaseObj>)
}