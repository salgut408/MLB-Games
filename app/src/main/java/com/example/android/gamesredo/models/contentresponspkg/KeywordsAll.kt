package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class KeywordsAll (

  @SerializedName("type"        ) var type        : String? = null,
  @SerializedName("value"       ) var value       : String? = null,
  @SerializedName("displayName" ) var displayName : String? = null

)