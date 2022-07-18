package com.example.android.gamesredo.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.gamesredo.repository.GameRepository

class HomeVMProviderFactory(
    val gameRepository: GameRepository
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(gameRepository) as T
    }


}