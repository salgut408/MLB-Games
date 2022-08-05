package com.example.android.gamesredo

import com.example.android.gamesredo.models.contentresponspkg.Highlights2
import com.google.gson.annotations.SerializedName


data class Highlights (

  @SerializedName("scoreboard"        ) var scoreboard        : String?            = null,
  @SerializedName("gameCenter"        ) var gameCenter        : String?            = null,
  @SerializedName("milestone"         ) var milestone         : String?            = null,
  @SerializedName("highlights"        ) var highlights2        : Highlights2?        = Highlights2(),
  @SerializedName("live"              ) var live              : Live?              = Live(),
  @SerializedName("items" ) var items : ArrayList<Items> = arrayListOf(),

  @SerializedName("scoreboardPreview" ) var scoreboardPreview : ScoreboardPreview? = ScoreboardPreview()

)