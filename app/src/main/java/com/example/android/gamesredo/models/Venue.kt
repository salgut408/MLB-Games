package com.example.android.gamesredo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
  tableName = "favorite_venues"
)
data class Venue (
  @PrimaryKey(
    autoGenerate = false
  )
  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("link" ) var link : String? = null

)