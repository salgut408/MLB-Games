package com.example.android.gamesredo.ui.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.gamesredo.R
import com.example.android.gamesredo.databinding.FragmentTodayBinding
import com.example.android.gamesredo.db.VenueDatabase
import com.example.android.gamesredo.repository.GameRepository
import com.example.android.gamesredo.ui.adapters.GamesAdapter

class TodayFragment : Fragment(R.layout.fragment_today) {

    private var _binding: FragmentTodayBinding? = null
    private val binding get() = _binding!!

    lateinit var todayViewModel: TodayViewModel
    lateinit var gameAdapter: GamesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val gameRepository = GameRepository(VenueDatabase(context))
        val viewModelProviderFactory = TodayVMProviderFactory(gameRepository)
        todayViewModel = ViewModelProvider(this, viewModelProviderFactory).get(TodayViewModel::class.java)


        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
        setUpRecyclerView()

    }

    private fun setUpRecyclerView(){
        gameAdapter = GamesAdapter()
        binding.rvGames.apply {
            adapter = gameAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }


}






































