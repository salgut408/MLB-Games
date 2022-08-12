package com.example.android.gamesredo.db.todaysgamesdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [GamesDatabaseObj::class],
    version = 1,
    exportSchema = false
)

abstract class TodaysGamesDatabase: RoomDatabase() {
    abstract fun getTodaysGamesDao(): TodaysGamesDao

    companion object{
        @Volatile
        private var instance: TodaysGamesDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it}

        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                TodaysGamesDatabase::class.java,
                "todays_games_db.db"
            ).build()
    }




}