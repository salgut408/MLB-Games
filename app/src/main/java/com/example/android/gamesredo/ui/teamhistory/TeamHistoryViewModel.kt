package com.example.android.gamesredo.ui.teamhistory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.domain.TeamsHistModel
import com.example.android.gamesredo.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamHistoryViewModel @Inject constructor(
    val gameRespository: GameRepository
): ViewModel() {
    private val _teamInfo: MutableLiveData<TeamsHistModel> = MutableLiveData()
    val teamInfo: LiveData<TeamsHistModel> get() = _teamInfo


//    init {
//
//    }

    fun getTeamInformation(teamIds: Int) = viewModelScope.launch {
        val result = gameRespository.getTeamHistoryInfo(teamIds)
        _teamInfo.postValue(result)
    }
}

