package com.example.android.gamesredo

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(
  tableName = "favorite_venues"
)
@Parcelize
data class Venue (
  @PrimaryKey(
    autoGenerate = false
  )
  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("link" ) var link : String? = null

): Parcelable