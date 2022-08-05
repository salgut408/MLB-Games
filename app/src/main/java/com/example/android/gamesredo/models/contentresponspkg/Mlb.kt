package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class Mlb (

  @SerializedName("type"            ) var type            : String?                 = null,
  @SerializedName("state"           ) var state           : String?                 = null,
  @SerializedName("date"            ) var date            : String?                 = null,
  @SerializedName("headline"        ) var headline        : String?                 = null,
  @SerializedName("seoTitle"        ) var seoTitle        : String?                 = null,
  @SerializedName("slug"            ) var slug            : String?                 = null,
  @SerializedName("blurb"           ) var blurb           : String?                 = null,
  @SerializedName("keywordsAll"     ) var keywordsAll     : ArrayList<KeywordsAll>  = arrayListOf(),
  @SerializedName("keywordsDisplay" ) var keywordsDisplay : ArrayList<String>       = arrayListOf(),
  @SerializedName("image"           ) var image           : Image?                  = Image(),
  @SerializedName("seoKeywords"     ) var seoKeywords     : String?                 = null,
  @SerializedName("body"            ) var body            : String?                 = null,
  @SerializedName("contributors"    ) var contributors    : ArrayList<Contributors> = arrayListOf(),
  @SerializedName("photo"           ) var photo           : Photo?                  = Photo(),
  @SerializedName("url"             ) var url             : String?                 = null,
  @SerializedName("media"           ) var media           : Media?                  = Media()

)