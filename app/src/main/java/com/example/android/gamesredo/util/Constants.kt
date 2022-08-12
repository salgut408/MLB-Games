package com.example.android.gamesredo.util

import android.content.Context
import com.example.android.gamesredo.Image
import com.example.android.gamesredo.Items
import com.example.android.gamesredo.R
import com.example.android.gamesredo.Team
import com.example.android.gamesredo.domain.ContentDetailModel
import com.example.android.gamesredo.models.contentresponspkg.Highlights2
import java.io.IOException

class Constants {
    companion object {
        const val BASE_URL = "https://statsapi.mlb.com/api/"

         val fakeImg = Image("title,","slt text", "tempurl", arrayListOf())
        val fakeItem: Items = Items("no",
            "state,",
            "date" ,
            "id",
            "headline",
            "seoTitle",
            "Slug",
            "blurb",
            arrayListOf(),
            arrayListOf(),
            fakeImg,
            true,
            "playback",
            "title",
            "desc",
            "dur",
            "uri",
            arrayListOf()

        )
        val fakeList: ArrayList<Items> = arrayListOf(fakeItem)
        val dummyHilights = Highlights2(fakeList)
        val dummyContentModel = ContentDetailModel(dummyHilights, "String", "string")






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









































