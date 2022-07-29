package com.example.android.gamesredo.ui.teamdetail

import android.graphics.Color
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.Colors
import com.example.android.gamesredo.MlbColorResponse
import com.example.android.gamesredo.MlbColors
import com.example.android.gamesredo.TeamRosterResponse
import com.example.android.gamesredo.domain.RosterModel
import com.example.android.gamesredo.repository.GameRepository
import com.example.android.gamesredo.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel
@Inject constructor(
    val gameRepository: GameRepository,
) : ViewModel() {

    private val _teamRoster: MutableLiveData<List<RosterModel>> = MutableLiveData()
    val teamRoster: LiveData<List<RosterModel>> get() = _teamRoster

    var colors: List<MlbColors>? = null

    init {
        getColors()
    }

    fun getRoster(teamId: Int) = viewModelScope.launch {
        val result = gameRepository.getRoster(teamId)
        _teamRoster.postValue(result)


//        teamRoster.postValue(Resource.Loading())
//    val response = gameRepository.getRoster(teamId)
//    teamRoster.postValue(handleTeamRosterResponse(response))

    }

    private fun handleTeamRosterResponse(response: Response<TeamRosterResponse>): Resource<TeamRosterResponse> {
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