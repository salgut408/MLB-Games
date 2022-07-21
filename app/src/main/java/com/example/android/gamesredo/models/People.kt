package com.example.android.gamesredo

import com.google.gson.annotations.SerializedName


data class People (

  @SerializedName("id"                 ) var id                 : Int?             = null,
  @SerializedName("fullName"           ) var fullName           : String?          = null,
  @SerializedName("link"               ) var link               : String?          = null,
  @SerializedName("firstName"          ) var firstName          : String?          = null,
  @SerializedName("lastName"           ) var lastName           : String?          = null,
  @SerializedName("primaryNumber"      ) var primaryNumber      : String?          = null,
  @SerializedName("birthDate"          ) var birthDate          : String?          = null,
  @SerializedName("currentAge"         ) var currentAge         : Int?             = null,
  @SerializedName("birthCity"          ) var birthCity          : String?          = null,
  @SerializedName("birthStateProvince" ) var birthStateProvince : String?          = null,
  @SerializedName("birthCountry"       ) var birthCountry       : String?          = null,
  @SerializedName("height"             ) var height             : String?          = null,
  @SerializedName("weight"             ) var weight             : Int?             = null,
  @SerializedName("active"             ) var active             : Boolean?         = null,
  @SerializedName("primaryPosition"    ) var primaryPosition    : PrimaryPosition? = PrimaryPosition(),
  @SerializedName("useName"            ) var useName            : String?          = null,
  @SerializedName("middleName"         ) var middleName         : String?          = null,
  @SerializedName("boxscoreName"       ) var boxscoreName       : String?          = null,
  @SerializedName("gender"             ) var gender             : String?          = null,
  @SerializedName("isPlayer"           ) var isPlayer           : Boolean?         = null,
  @SerializedName("isVerified"         ) var isVerified         : Boolean?         = null,
  @SerializedName("draftYear"          ) var draftYear          : Int?             = null,
  @SerializedName("mlbDebutDate"       ) var mlbDebutDate       : String?          = null,
  @SerializedName("batSide"            ) var batSide            : BatSide?         = BatSide(),
  @SerializedName("pitchHand"          ) var pitchHand          : PitchHand?       = PitchHand(),
  @SerializedName("nameFirstLast"      ) var nameFirstLast      : String?          = null,
  @SerializedName("nameSlug"           ) var nameSlug           : String?          = null,
  @SerializedName("firstLastName"      ) var firstLastName      : String?          = null,
  @SerializedName("lastFirstName"      ) var lastFirstName      : String?          = null,
  @SerializedName("lastInitName"       ) var lastInitName       : String?          = null,
  @SerializedName("initLastName"       ) var initLastName       : String?          = null,
  @SerializedName("fullFMLName"        ) var fullFMLName        : String?          = null,
  @SerializedName("fullLFMName"        ) var fullLFMName        : String?          = null,
  @SerializedName("strikeZoneTop"      ) var strikeZoneTop      : Double?          = null,
  @SerializedName("strikeZoneBottom"   ) var strikeZoneBottom   : Double?          = null

)