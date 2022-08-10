package com.example.android.gamesredo.util

import android.content.Context
import com.example.android.gamesredo.R
import com.example.android.gamesredo.Team
import java.io.IOException

class Constants {
    companion object {
        const val BASE_URL = "https://statsapi.mlb.com/api/"







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









































