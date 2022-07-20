package com.example.android.gamesredo.ui.teamdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.TeamRosterResponse
import com.example.android.gamesredo.repository.GameRepository
import com.example.android.gamesredo.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor (
    val gameRepository: GameRepository
        ): ViewModel() {

    val teamRoster: MutableLiveData<Resource<TeamRosterResponse>> = MutableLiveData()

//    init {
//    getRoster(145)
//    }
    fun getRoster(teamId: Int) = viewModelScope.launch {

        teamRoster.postValue(Resource.Loading())
    val response = gameRepository.getRoster(teamId)
    teamRoster.postValue(handleTeamRosterResponse(response))

}
    private fun handleTeamRosterResponse(response: Response<TeamRosterResponse>) : Resource<TeamRosterResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

}