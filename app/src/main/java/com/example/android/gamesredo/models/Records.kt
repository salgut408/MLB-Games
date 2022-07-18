package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Records (

  @SerializedName("standingsType" ) var standingsType : String?                = null,
  @SerializedName("league"        ) var league        : League?                = League(),
  @SerializedName("division"      ) var division      : Division?              = Division(),
  @SerializedName("sport"         ) var sport         : Sport?                 = Sport(),
  @SerializedName("lastUpdated"   ) var lastUpdated   : String?                = null,
  @SerializedName("teamRecords"   ) var teamRecords   : ArrayList<TeamRecords> = arrayListOf()

)