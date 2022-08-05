package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Summary (

  @SerializedName("hasPreviewArticle"  ) var hasPreviewArticle  : Boolean? = null,
  @SerializedName("hasRecapArticle"    ) var hasRecapArticle    : Boolean? = null,
  @SerializedName("hasWrapArticle"     ) var hasWrapArticle     : Boolean? = null,
  @SerializedName("hasHighlightsVideo" ) var hasHighlightsVideo : Boolean? = null

)