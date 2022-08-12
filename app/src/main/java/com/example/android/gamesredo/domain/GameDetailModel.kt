package com.example.android.gamesredo.domain

import com.example.android.gamesredo.models.Defense
import com.example.android.gamesredo.models.Innings
import com.example.android.gamesredo.models.Offense
import com.example.android.gamesredo.models.Teams2
import com.google.gson.annotations.SerializedName

data class GameDetailModel(
   val currentInning        : Int?               = null,
   val currentInningOrdinal : String?            = null,
   val inningState          : String?            = null,
   val inningHalf           : String?            = null,
   val isTopInning          : Boolean?           = null,
   val scheduledInnings     : Int?               = null,
   val innings              : ArrayList<Innings> = arrayListOf(),
   val teams2                : Teams2?             = Teams2(),
   val defense              : Defense?           = Defense(),
   val offense              : Offense?           = Offense(),
   val balls                : Int?               = null,
   val strikes              : Int?               = null,
   val outs                 : Int?               = null,
   val homeScore: Int? = null,
   val awaySCore: Int? = null


)
