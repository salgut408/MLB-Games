package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamPlayByPlay (

  @SerializedName("springLeague"  ) var springLeague  : SpringLeague? = SpringLeague(),
  @SerializedName("allStarStatus" ) var allStarStatus : String?       = null,
  @SerializedName("id"            ) var id            : Int?          = null,
  @SerializedName("name"          ) var name          : String?       = null,
  @SerializedName("link"          ) var link          : String?       = null

): Parcelable