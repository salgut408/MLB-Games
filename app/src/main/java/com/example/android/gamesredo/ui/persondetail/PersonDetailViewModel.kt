package com.example.android.gamesredo.ui.persondetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

//    init {
//
//    }
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

}