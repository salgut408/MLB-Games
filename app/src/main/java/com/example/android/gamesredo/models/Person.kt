package com.example.android.gamesredo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person (

  @SerializedName("id"       ) var id       : Int?    = null,
  @SerializedName("fullName" ) var fullName : String? = null,
  @SerializedName("link"     ) var link     : String? = null,
  @SerializedName("firstName" ) var firstName : String? = null,
  @SerializedName("lastName"  ) var lastName  : String? = null

): Parcelable