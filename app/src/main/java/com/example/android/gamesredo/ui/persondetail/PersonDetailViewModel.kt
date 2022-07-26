package com.example.android.gamesredo.ui.persondetail

import android.graphics.Color
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.gamesredo.MlbColors
import com.example.android.gamesredo.People
import com.example.android.gamesredo.PeopleResponse
import com.example.android.gamesredo.repository.GameRepository
import com.example.android.gamesredo.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor(
    val gameRepository: GameRepository
): ViewModel() {
    val playerInfo: MutableLiveData<Resource<PeopleResponse>> = MutableLiveData()

    var colors: List<MlbColors>?=null

    init {
        getColors()
    }
    fun getPersonInfo(personId: Int) = viewModelScope.launch {
        playerInfo.postValue(Resource.Loading())

         val response = gameRepository.getPersonInfo(personId)
        playerInfo.postValue(handlePersonResponse(response))

}
    private fun handlePersonResponse(response: Response<PeopleResponse>): Resource<PeopleResponse> {
        if ( response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


    // colors

    fun getColors() = viewModelScope.launch {
        colors = gameRepository.getColorData().mlbColors
    }

    fun setTxtAndBgrndColor(team: String, txtView: TextView){
        for (i in colors!!){
            if (i.name.equals(team)) {
                txtView.setTextColor(Color.parseColor(i.colors?.primary))
                txtView.setBackgroundColor(Color.parseColor(i.colors?.secondary))
            }
        }
    }



    fun getPrimaryColor(team: String): String {
        for (i in colors!!) {
            if ( i.name.equals(team)) {
                return i.colors?.primary.toString()
            }
        }
        return "Null"
    }

    fun getSecondaryColor(team: String): String {
        for (i in colors!!) {
            if ( i.name.equals(team)) {
                return i.colors?.secondary.toString()
            }
        }
        return "Null"
    }





}