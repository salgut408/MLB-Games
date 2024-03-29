package com.example.android.gamesredo.ui.today

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.MlbColorResponse
import com.example.android.gamesredo.MlbColors
import com.example.android.gamesredo.MlbResponse
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
    val gameRepository: GameRepository
) : ViewModel() {

    val allGames: MutableLiveData<Resource<MlbResponse>> = MutableLiveData()

    var colors: MlbColorResponse? = null

    init {
        getGames(1)

        getVmColorData()





    }



    fun getGames(sportId: Int) = viewModelScope.launch {
        allGames.postValue(Resource.Loading())
        val response = gameRepository.getGames(1)
        allGames.postValue(handleMLBResponse(response))
    }

    private fun handleMLBResponse(response: Response<MlbResponse>) : Resource<MlbResponse> {
        if(response.isSuccessful) {
            response.body()?.let{ resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

  fun getVmColorData() = viewModelScope.launch {
      colors = gameRepository.getColorData()

  }

}
































