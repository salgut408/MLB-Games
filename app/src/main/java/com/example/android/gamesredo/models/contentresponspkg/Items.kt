package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Items (

  @SerializedName("type"             ) var type             : String?                    = null,
  @SerializedName("state"            ) var state            : String?                    = null,
  @SerializedName("date"             ) var date             : String?                    = null,
  @SerializedName("id"               ) var id               : String?                    = null,
  @SerializedName("headline"         ) var headline         : String?                    = null,
  @SerializedName("seoTitle"         ) var seoTitle         : String?                    = null,
  @SerializedName("slug"             ) var slug             : String?                    = null,
  @SerializedName("blurb"            ) var blurb            : String?                    = null,
  @SerializedName("keywordsAll"      ) var keywordsAll      : ArrayList<KeywordsAll>     = arrayListOf(),
  @SerializedName("keywordsDisplay"  ) var keywordsDisplay  : ArrayList<KeywordsDisplay> = arrayListOf(),
  @SerializedName("image"            ) var image            : Image?                     = Image(),
  @SerializedName("noIndex"          ) var noIndex          : Boolean?                   = null,
  @SerializedName("mediaPlaybackId"  ) var mediaPlaybackId  : String?                    = null,
  @SerializedName("title"            ) var title            : String?                    = null,
  @SerializedName("description"      ) var description      : String?                    = null,
  @SerializedName("duration"         ) var duration         : String?                    = null,
  @SerializedName("mediaPlaybackUrl" ) var mediaPlaybackUrl : String?                    = null,
  @SerializedName("playbacks"        ) var playbacks        : ArrayList<Playbacks>       = arrayListOf()

)