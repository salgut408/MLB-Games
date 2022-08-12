package com.example.android.gamesredo.db.venuedb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.gamesredo.Venue

@Database(
    entities = [Venue::class],
    version = 1,
    exportSchema = false
)
abstract class VenueDatabase: RoomDatabase() {

    abstract fun getDao(): VenueDao


    companion object{
        @Volatile
        private var instance: VenueDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                VenueDatabase::class.java,
                "venue_db.db"
            ).build()
    }


}


















