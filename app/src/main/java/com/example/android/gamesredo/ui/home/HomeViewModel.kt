package com.example.android.gamesredo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.AmericanLeagueStandingResponse
import com.example.android.gamesredo.MlbResponse
import com.example.android.gamesredo.Resource
import com.example.android.gamesredo.repository.GameRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(
    val gameRepository: GameRepository
) : ViewModel() {

    val allTeamsRecords: MutableLiveData<Resource<AmericanLeagueStandingResponse>> = MutableLiveData()

    init {
        getRecords(103)
    }

    fun getRecords(leagueId: Int) = viewModelScope.launch {
        allTeamsRecords.postValue(Resource.Loading())
        val response = gameRepository.getRecords(103)
        allTeamsRecords.postValue(handleAmericanLeagueStandingResponse(response))
    }

    private fun handleAmericanLeagueStandingResponse(response: Response<AmericanLeagueStandingResponse>) : Resource<AmericanLeagueStandingResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

}