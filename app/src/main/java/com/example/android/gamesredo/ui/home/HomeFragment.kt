package com.example.android.gamesredo.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.gamesredo.AmericanLeagueStandingResponse
import com.example.android.gamesredo.Resource
import com.example.android.gamesredo.databinding.FragmentHomeBinding
import com.example.android.gamesredo.db.VenueDatabase
import com.example.android.gamesredo.repository.GameRepository
import com.example.android.gamesredo.ui.adapters.StandingsAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    lateinit var homeViewModel: HomeViewModel
    lateinit var standingsAdapter: StandingsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val gameRepository=GameRepository(VenueDatabase(context?.applicationContext!!))

       val viewModelProviderFactory = HomeVMProviderFactory(gameRepository)
        homeViewModel = ViewModelProvider(this,viewModelProviderFactory).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        homeViewModel.allTeamsRecords.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { americanLeagueStandingResponse ->
                        val list = americanLeagueStandingResponse.records[1].teamRecords
                        list.addAll(americanLeagueStandingResponse.records[0].teamRecords)
                        americanLeagueStandingResponse.records[2].teamRecords
                        standingsAdapter.differ.submitList(list)
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Log.e("tag", "response not successful")
                    }
                }
                is Resource.Loading -> {
                    Log.e("tag", "response loading")

                }
            }
        })


    }

    private fun setUpRecyclerView() {
        standingsAdapter = StandingsAdapter()
        binding.rvStandings.apply {
            adapter=standingsAdapter
            layoutManager=LinearLayoutManager(this.context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}