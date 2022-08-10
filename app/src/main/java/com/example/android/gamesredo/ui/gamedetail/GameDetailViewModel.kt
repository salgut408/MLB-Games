package com.example.android.gamesredo.ui.gamedetail

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.Live
import com.example.android.gamesredo.MlbColors
import com.example.android.gamesredo.domain.GameDetailModel
import com.example.android.gamesredo.domain.GamePredictionModel
import com.example.android.gamesredo.domain.PlayByPlayModel
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

    val imgsrc: MutableLiveData<String> = MutableLiveData()

    val vidImg: MutableLiveData<String> = MutableLiveData()

    val hilightText: MutableLiveData<String> = MutableLiveData()

    var colors: List<MlbColors>? = null

    private val _gamePrediction: MutableLiveData<GamePredictionModel> = MutableLiveData()
    val gamePredictions: LiveData<GamePredictionModel> get() = _gamePrediction

    private val _playByPlayInfo: MutableLiveData<PlayByPlayModel> = MutableLiveData()
    val playByPlayInfo: LiveData<PlayByPlayModel> get() = _playByPlayInfo


    init {
        getColors()
    }


    fun getPlayByPlay(gamePk: Int) = viewModelScope.launch {
        try {
            val result = gameRepository.getGamePlayByPlay(gamePk)
            _playByPlayInfo.postValue(result)
        } catch (e: Throwable) {

        }


    }

    fun getLineScore(gamePk: Int) = viewModelScope.launch {
        val result = gameRepository.getGameDetailLineScore(gamePk)
        _gameLineScore.postValue(result)
    }

    fun getImgBlurb(gamePk: Int) = viewModelScope.launch {
        val result = gameRepository.getContent(gamePk)
        if (result.highlights?.items?.get(0)?.blurb == null) {
            hilightText.postValue("N/a")
        } else {
            hilightText.postValue(result.highlights?.items?.get(0)?.blurb!!)
        }
    }

    fun getVidSrc(gamePk: Int) = viewModelScope.launch {
        val result = gameRepository.getContent(gamePk)
        if (result.vid == null) {
            vidImg.postValue("N/a")
        } else {
            vidImg.postValue(result.vid!!)
        }
    }


    fun getImg(gamePk: Int) = viewModelScope.launch {
        val result = gameRepository.getContent(gamePk)
        imgsrc.postValue(result.img!!)

    }

    fun getPredictions(gamePk: Int) = viewModelScope.launch {
        try {
            val result = gameRepository.getGamePredictions(gamePk)
            _gamePrediction.postValue(result)
        } catch (e: Throwable) {
        }
    }

    fun getColors() = viewModelScope.launch {
        colors = gameRepository.getColorData().mlbColors
    }

    fun getPrimaryColor(team: String): String {
        for (i in colors!!) {
            if (i.name.equals(team)) {
                val color = i.colors?.primary.toString()
                return color
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

    fun getTeamLogo(team: String): String {
        for (i in colors!!) {
            if (i.name.equals(team)) {
                return i.logo.toString()
            }
        }
        return "Null"
    }


}