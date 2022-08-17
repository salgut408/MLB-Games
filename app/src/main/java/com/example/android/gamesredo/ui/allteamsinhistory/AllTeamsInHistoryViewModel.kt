package com.example.android.gamesredo.ui.allteamsinhistory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.domain.AllTeamModel
import com.example.android.gamesredo.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllTeamsInHistoryViewModel
@Inject constructor(
    val gameRepository: GameRepository
): ViewModel() {

    private val _allTeamsEver: MutableLiveData<List<AllTeamModel>> = MutableLiveData()
    val allTeamsEver: LiveData<List<AllTeamModel>> get() = _allTeamsEver


    init {
        getAllTeamsInHistory()
    }

    fun getAllTeamsInHistory() = viewModelScope.launch {
        val result = gameRepository.getAllTeamsInHistory()
        _allTeamsEver.postValue(result)
    }

}