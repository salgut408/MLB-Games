package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Editorial (

  @SerializedName("preview"  ) var preview  : Preview? = Preview(),
  @SerializedName("articles" ) var articles : String?  = null,
  @SerializedName("recap"    ) var recap    : Recap?   = Recap(),
  @SerializedName("wrap"     ) var wrap     : Wrap?    = Wrap()

)