package com.example.android.gamesredo.ui.today

import android.graphics.Color
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.MlbColorResponse
import com.example.android.gamesredo.MlbColors
import com.example.android.gamesredo.MlbResponse
import com.example.android.gamesredo.domain.GamesModel
import com.example.android.gamesredo.util.Resource
import com.example.android.gamesredo.repository.GameRepository
import com.example.android.gamesredo.util.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel

class TodayViewModel
@Inject constructor(
    val gameRepository: GameRepository,
) : ViewModel() {

    private val _allGames: MutableLiveData<List<GamesModel>> = MutableLiveData()
    val allGames: LiveData<List<GamesModel>> get() = _allGames



    var colors: List<MlbColors>? = null

    init {
        getGames(1)

        getColors()


    }


    fun getGames(sportId: Int) = viewModelScope.launch {
        val result = gameRepository.getGames(1)
        _allGames.postValue(result)
//        allGames.postValue(Resource.Loading())
//        val response = gameRepository.getGames(1)
//        allGames.postValue(handleMLBResponse(response))
    }

    private fun handleMLBResponse(response: Response<MlbResponse>): Resource<MlbResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun getColors() = viewModelScope.launch {
        colors = gameRepository.getColorData().mlbColors
    }

    fun setTxtAndBgrndColor(team: String, txtView: TextView) {
        for (i in colors!!) {
            if (i.name.equals(team)) {
                txtView.setTextColor(Color.parseColor(i.colors?.primary))
                txtView.setBackgroundColor(Color.parseColor(i.colors?.secondary))
            }
        }
    }


    fun getPrimaryColor(team: String): String {
        for (i in colors!!) {
            if (i.name.equals(team)) {
                return i.colors?.primary.toString()
            }
        }
        return "Null"
    }

    fun getSecondaryColor(team: String): String {
        for (i in colors!!) {
            if (i.name.equals(team)) {
                return i.colors?.secondary.toString()
            }
        }
        return "Null"
    }

}
































