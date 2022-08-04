package com.example.android.gamesredo.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.gamesredo.Team
import com.example.android.gamesredo.TeamRecords
import com.example.android.gamesredo.util.Resource
import com.example.android.gamesredo.databinding.FragmentHomeBinding
import com.example.android.gamesredo.db.VenueDatabase
import com.example.android.gamesredo.domain.StandingsModel
import com.example.android.gamesredo.repository.GameRepository
import com.example.android.gamesredo.ui.adapters.StandingsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    val homeViewModel: HomeViewModel by viewModels()

    lateinit var standingsAdapter: StandingsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        standingsAdapter.setOnItemClickListener {
            this.findNavController().navigate(
                HomeFragmentDirections.actionNavigationHomeToTeamDetail(it)
            )
        }
        homeViewModel.allTeamsRecords.observe(viewLifecycleOwner,
            Observer<List<StandingsModel>> { standing ->
                standing.apply { standingsAdapter.differ.submitList(standing) }
            })



    }

    private fun setUpRecyclerView() {
        val colors = homeViewModel.colors
        standingsAdapter = StandingsAdapter(colors!!)
        binding.rvStandings.apply {
            adapter = standingsAdapter
            layoutManager = LinearLayoutManager(this.context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}