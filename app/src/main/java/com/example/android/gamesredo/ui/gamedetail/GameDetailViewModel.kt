package com.example.android.gamesredo.ui.gamedetail

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.domain.GameDetailModel
import com.example.android.gamesredo.domain.GamePredictionModel
import com.example.android.gamesredo.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel
@Inject constructor(
    val gameRepository: GameRepository,
) : ViewModel() {

    private val _gameLineScore: MutableLiveData<GameDetailModel> = MutableLiveData()
    val gameLineScore: LiveData<GameDetailModel> get() = _gameLineScore

    private val _gamePrediction: MutableLiveData<GamePredictionModel> = MutableLiveData()
    val gamePredictions: LiveData<GamePredictionModel> get() = _gamePrediction

    init {

    }

    fun getLineScore(gamePk: Int) = viewModelScope.launch {
        val result = gameRepository.getGameDetailLineScore(gamePk)
        _gameLineScore.postValue(result)
    }

    fun getPredictions(gamePk: Int) = viewModelScope.launch {
       try {
           val result = gameRepository.getGamePredictions(gamePk)
           _gamePrediction.postValue(result)
       } catch (e: Throwable) {
       }
    }

}