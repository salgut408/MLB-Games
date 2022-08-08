package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomePlayByPlay (

  @SerializedName("team"        ) var team        : TeamPlayByPlay?        = TeamPlayByPlay(),
  @SerializedName("inning"      ) var inning      : Int?         = null,
  @SerializedName("pitcher"     ) var pitcher     : PitcherPlayByPlay?     = PitcherPlayByPlay(),
  @SerializedName("batter"      ) var batter      : BatterPlayByPlay?      = BatterPlayByPlay(),
  @SerializedName("coordinates" ) var coordinates : Coordinates? = Coordinates(),
  @SerializedName("type"        ) var type        : String?      = null,
  @SerializedName("description" ) var description : String?      = null

): Parcelable