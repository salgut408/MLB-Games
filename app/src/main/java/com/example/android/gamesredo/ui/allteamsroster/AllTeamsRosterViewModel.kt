package com.example.android.gamesredo.ui.allteamsroster

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.Live
import com.example.android.gamesredo.domain.RosterModel
import com.example.android.gamesredo.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AllTeamsRosterViewModel
@Inject constructor(
    val gameRepository: GameRepository
): ViewModel() {

    private val _allTeamsTeamRoster: MutableLiveData<List<RosterModel>> = MutableLiveData()
    val allTeamsTeamRoster: LiveData<List<RosterModel>> get() = _allTeamsTeamRoster


//    init {
////        getAllTeamsRosterList()
//    }

    fun getAllTeamsRosterList(teamId: Int) = viewModelScope.launch {
        val result = gameRepository.getRoster(teamId)
        _allTeamsTeamRoster.postValue(result)
    }

}