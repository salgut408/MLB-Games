package com.example.android.gamesredo.util

import android.content.Context
import com.example.android.gamesredo.R
import java.io.IOException

class Constants {
    companion object{
        const val BASE_URL = "https://statsapi.mlb.com/api/"

        val img = R.drawable.ic_chicago_cubs
        val img2 = R.drawable.ic_chicago_white_sox
        val img3 = R.drawable.ic_new_york_yankees
        val img4 = R.drawable.ic_toronto_blue_jays
        val img5 = R.drawable.ic_tampa_bay_rays
        val list = listOf<Int>(img,img2)

//
//        fun getJsonDataFromAsset(context: Context, fileName: String) : String? {
//            val jsonString: String
//            try {
//                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
//            } catch (ioException: IOException)
//        }


    }
}









































