package com.example.android.gamesredo.ui.home

import android.graphics.Color
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.AmericanLeagueStandingResponse
import com.example.android.gamesredo.MlbColors
import com.example.android.gamesredo.domain.StandingsModel
import com.example.android.gamesredo.util.Resource
import com.example.android.gamesredo.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel

class HomeViewModel
@Inject constructor(
    val gameRepository: GameRepository,
) : ViewModel() {

    private val _allTeamsRecords: MutableLiveData<List<StandingsModel>> = MutableLiveData()
    val allTeamsRecords: LiveData<List<StandingsModel>> get() = _allTeamsRecords

    private val _americanLeagueRecords: MutableLiveData<List<StandingsModel>> = MutableLiveData()
    val americanLeagueRecords: LiveData<List<StandingsModel>> get() = _americanLeagueRecords

    var colors: List<MlbColors>? = null

    init {
        getRecords(103, 104)
        getColors()
        getRecordsForDb(103, 104)
        getAmericanLeagueStandings(103)
    }

//    fun getRecords(leagueId: Int,leagueId2: Int ) = viewModelScope.launch {
//        val result = gameRepository.getRecords(103,102)
//        _allTeamsRecords.postValue(result)
//    }


    fun getRecordsForDb(leagueId: Int, leagueId2: Int)     = viewModelScope.launch {
        gameRepository.getStandingsForDatabase()
    }

    fun getAmericanLeagueStandings(leagueId: Int = 103) = viewModelScope.launch {
        gameRepository.records.collect {record ->
            _americanLeagueRecords.postValue(record)
        }
    }

    fun getRecords(leagueId1: Int, leagueId2: Int) = viewModelScope.launch {
        gameRepository.records.collect { record ->
            _allTeamsRecords.postValue(record)
        }
    }

    fun getColors() = viewModelScope.launch {
        colors = gameRepository.getColorData().mlbColors
    }

    private fun handleAmericanLeagueStandingResponse(response: Response<AmericanLeagueStandingResponse>): Resource<AmericanLeagueStandingResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    fun setTxtAndBgrndColor(team: String, txtView: TextView) {
        for (i in colors!!) {
            if(i.name.equals(team)) {
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