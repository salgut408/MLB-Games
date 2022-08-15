package com.example.android.gamesredo.db.playerdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.gamesredo.BatSide
import com.example.android.gamesredo.PitchHand
import com.example.android.gamesredo.PrimaryPosition

@Entity(tableName = "players_database")
data class PlayerDatabaseObj(
    @PrimaryKey(autoGenerate = false)
    val id                 : Int?             = null,
    val fullName           : String?          = null,
    val link               : String?          = null,
    val firstName          : String?          = null,
    val lastName           : String?          = null,
    val primaryNumber      : String?          = null,
    val birthDate          : String?          = null,
    val currentAge         : Int?             = null,
    val birthCity          : String?          = null,
    val birthStateProvince : String?          = null,
    val birthCountry       : String?          = null,
    val height             : String?          = null,
    val weight             : Int?             = null,
    val active             : Boolean?         = null,
    val primaryPosition    : PrimaryPosition? = PrimaryPosition(),
    val useName            : String?          = null,
    val middleName         : String?          = null,
    val boxscoreName       : String?          = null,
    val gender             : String?          = null,
    val isPlayer           : Boolean?         = null,
    val isVerified         : Boolean?         = null,
    val draftYear          : Int?             = null,
    val mlbDebutDate       : String?          = null,
    val batSide            : BatSide?         = BatSide(),
    val pitchHand          : PitchHand?       = PitchHand(),
    val nameFirstLast      : String?          = null,
    val nameSlug           : String?          = null,
    val firstLastName      : String?          = null,
    val lastFirstName      : String?          = null,
    val lastInitName       : String?          = null,
    val initLastName       : String?          = null,




) {
}