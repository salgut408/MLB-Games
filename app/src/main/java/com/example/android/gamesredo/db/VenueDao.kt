package com.example.android.gamesredo.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.gamesredo.Venue

@Dao
interface VenueDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(venue: Venue): Long

    @Query("SELECT * FROM favorite_venues")
    fun getAllVenues(): LiveData<List<Venue>>

    @Delete
    suspend fun deleteVenue(venue: Venue)

}