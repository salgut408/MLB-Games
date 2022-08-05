package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class GameContentResponse (

  @SerializedName("copyright"  ) var copyright  : String?     = null,
  @SerializedName("link"       ) var link       : String?     = null,
  @SerializedName("editorial"  ) var editorial  : Editorial?  = Editorial(),
  @SerializedName("media"      ) var media      : Media?      = Media(),
  @SerializedName("highlights" ) var highlights : Highlights? = Highlights(),
  @SerializedName("summary"    ) var summary    : Summary?    = Summary(),
  @SerializedName("gameNotes"  ) var gameNotes  : GameNotes?  = GameNotes()

)