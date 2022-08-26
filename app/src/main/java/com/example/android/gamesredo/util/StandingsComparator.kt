package com.example.android.gamesredo.util

import com.example.android.gamesredo.domain.StandingsModel

class StandingsComparator {
    companion object : Comparator<StandingsModel> {
        override fun compare(a: StandingsModel?, b: StandingsModel?): Int = when {
            a?.sportRank?.toInt() != b?.sportRank?.toInt() -> a?.sportRank?.toInt()!! - b?.sportRank?.toInt()!!
            else -> 0
        }
    }
}