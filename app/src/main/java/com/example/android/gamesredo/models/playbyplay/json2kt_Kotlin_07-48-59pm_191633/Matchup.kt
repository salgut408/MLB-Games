package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Matchup (

  @SerializedName("batter"                 ) var batter                 : BatterPlayByPlay?                       = BatterPlayByPlay(),
  @SerializedName("batSide"                ) var batSide                : BatSidePlayByPlay?                      = BatSidePlayByPlay(),
  @SerializedName("pitcher"                ) var pitcher                : PitcherPlayByPlay?                      = PitcherPlayByPlay(),
  @SerializedName("pitchHand"              ) var pitchHand              : PitchHandPlayByPlay?                    = PitchHandPlayByPlay(),
  @SerializedName("batterHotColdZoneStats" ) var batterHotColdZoneStats : BatterHotColdZoneStats?       = BatterHotColdZoneStats(),
  @SerializedName("batterHotColdZones"     ) var batterHotColdZones     : ArrayList<BatterHotColdZones> = arrayListOf(),
  @SerializedName("pitcherHotColdZones"    ) var pitcherHotColdZones    : ArrayList<String>             = arrayListOf(),
  @SerializedName("splits"                 ) var splits                 : Splits?                       = Splits()

): Parcelable