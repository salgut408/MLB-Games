package com.example.android.gamesredo.ui.leaders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.LeagueLeadersResponse
import com.example.android.gamesredo.repository.GameRepository
import com.example.android.gamesredo.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LeadersViewModel
@Inject constructor(
    val gameRepository: GameRepository
) : ViewModel() {

    val allLeaders: MutableLiveData<Resource<LeagueLeadersResponse>> = MutableLiveData()

    init {
        getLeaders(2022, "homeruns")
    }


    fun getLeaders(season: Int, leaderCatagories: String) = viewModelScope.launch {
        allLeaders.postValue(Resource.Loading())
        val response = gameRepository.getHomerunLeaders(2022, "homeruns")
        allLeaders.postValue(handleHRLeadersResponse(response))
    }

    private fun handleHRLeadersResponse(response: Response<LeagueLeadersResponse>) : Resource<LeagueLeadersResponse> {
        if (response.isSuccessful) {
            response.body()?.let {  resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }



}