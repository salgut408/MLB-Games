package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamRosterResponse (

  @SerializedName("copyright"  ) var copyright  : String?           = null,
  @SerializedName("roster"     ) var roster     : ArrayList<Roster> = arrayListOf(),
  @SerializedName("link"       ) var link       : String?           = null,
  @SerializedName("teamId"     ) var teamId     : Int?              = null,
  @SerializedName("rosterType" ) var rosterType : String?           = null

): Parcelable