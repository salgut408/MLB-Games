package com.example.android.gamesredo.db

import androidx.room.TypeConverter
import com.example.android.gamesredo.Teams

class Converters {
    @TypeConverter
    fun fromTeams(teams: Teams): String {
        return teams?.away?.team?.name + teams?.home?.team?.name
    }

//    @TypeConverter
//    fun toTeams(away: String, home: String) :Teams {
//        return Teams(away, home)
//    }
}