package com.example.android.gamesredo.domain

import android.os.Parcelable
import com.example.android.gamesredo.Division
import com.example.android.gamesredo.League
import com.example.android.gamesredo.SportDto
import com.example.android.gamesredo.TeamRecords
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecordsModel(

    val standingsType : String?                = null,
    val league        : League?                = League(),
    val division      : Division?              = Division(),
    val sport         : SportDto?                 = SportDto(),
    val lastUpdated   : String?                = null,
    val teamRecords   : ArrayList<TeamRecords> = arrayListOf()


): Parcelable
