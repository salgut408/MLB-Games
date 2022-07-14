package com.example.android.gamesredo.ui.today


import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.gamesredo.repository.GameRepository

class TodayVMProviderFactory(
   val gameRepository: GameRepository
):ViewModelProvider.Factory {

   override fun <T : ViewModel> create(modelClass: Class<T>): T {
      return TodayViewModel(gameRepository) as T
   }


}