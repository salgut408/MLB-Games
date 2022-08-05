package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Media (

  @SerializedName("epg"           ) var epg           : ArrayList<Epg>          = arrayListOf(),
  @SerializedName("epgAlternate"  ) var epgAlternate  : ArrayList<EpgAlternate> = arrayListOf(),
  @SerializedName("milestones"    ) var milestones    : String?                 = null,
  @SerializedName("featuredMedia" ) var featuredMedia : FeaturedMedia?          = FeaturedMedia(),
  @SerializedName("freeGame"      ) var freeGame      : Boolean?                = null,
  @SerializedName("enhancedGame"  ) var enhancedGame  : Boolean?                = null

)