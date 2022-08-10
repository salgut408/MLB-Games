package com.example.android.gamesredo.util

import android.content.Context
import com.example.android.gamesredo.R
import com.example.android.gamesredo.Team
import java.io.IOException

class Constants {
    companion object {
        const val BASE_URL = "https://statsapi.mlb.com/api/"

        const val ACTION_START_OR_RESUME_SERVICE ="ACTION_START_OR_RESUME_SERVICE"
        const val ACTION_PAUSE_SERVICE ="ACTION_PAUSE_SERVICE"
        const val ACTION_STOP_SERVICE ="ACTION_STOP_SERVICE"






        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }


    }
}









































