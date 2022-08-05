package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Highlights (

  @SerializedName("scoreboard"        ) var scoreboard        : String?            = null,
  @SerializedName("gameCenter"        ) var gameCenter        : String?            = null,
  @SerializedName("milestone"         ) var milestone         : String?            = null,
  @SerializedName("highlights"        ) var highlights        : Highlights?        = Highlights(),
  @SerializedName("live"              ) var live              : Live?              = Live(),
  @SerializedName("scoreboardPreview" ) var scoreboardPreview : ScoreboardPreview? = ScoreboardPreview()

)