package com.example.android.gamesredo.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.android.gamesredo.Team
import com.example.android.gamesredo.Teams
@ProvidedTypeConverter
class Converters {
    @TypeConverter
    fun fromTeam(team: Team): String {
        return team.name.toString()
    }

//    @TypeConverter
//    fun toTeams(away: String, home: String) :Teams {
//        return Teams(away, home)
//    }
}