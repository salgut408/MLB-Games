package com.example.android.gamesredo.db.standingsdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android.gamesredo.db.Converters

@Database(
    entities = [StandingsDatabaseObj::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)

abstract class StandingsDatabase: RoomDatabase() {
    abstract fun getStandingsDao(): StandingsDao

    companion object{
        @Volatile
        private var instance: StandingsDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(StandingsDatabase.LOCK) {
            StandingsDatabase.instance ?: StandingsDatabase.createDatabase(context)
                .also { StandingsDatabase.instance = it}
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                StandingsDatabase::class.java,
                "standingsDb.db"
            ).build()

    }
}