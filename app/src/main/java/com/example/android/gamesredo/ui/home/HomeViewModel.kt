package com.example.android.gamesredo.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.AmericanLeagueStandingResponse
import com.example.android.gamesredo.util.Resource
import com.example.android.gamesredo.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel

class HomeViewModel
    @Inject constructor(
    val gameRepository: GameRepository
) : ViewModel() {

    val allTeamsRecords: MutableLiveData<Resource<AmericanLeagueStandingResponse>> = MutableLiveData()

    init {
        getRecords(103, 104)
    }

    fun getRecords(leagueId: Int,leagueId2: Int ) = viewModelScope.launch {
        allTeamsRecords.postValue(Resource.Loading())
        val response = gameRepository.getRecords(103, 104)
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