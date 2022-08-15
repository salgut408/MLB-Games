package com.example.android.gamesredo.ui.teamhistory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.gamesredo.R
import com.example.android.gamesredo.Team
import com.example.android.gamesredo.databinding.FragmentTeamHistoryBinding
import com.example.android.gamesredo.domain.LeadersModel
import com.example.android.gamesredo.domain.TeamsHistModel
import com.example.android.gamesredo.ui.adapters.LeadersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamHistoryFragment : Fragment() {

    lateinit var binding: FragmentTeamHistoryBinding
    val teamHistoryViewModel: TeamHistoryViewModel by viewModels()
    lateinit var team: Team
    lateinit var leaderAdapter: LeadersAdapter

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTeamHistoryBinding.inflate(inflater)
        team = TeamHistoryFragmentArgs.fromBundle(requireArguments()).teamHistArgs
        teamHistoryViewModel.getTeamInformation(team.id!!.toInt())
        teamHistoryViewModel.getLeaders(2022, "homeruns", team.id!!.toInt())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        teamHistoryViewModel.allLeaders.observe(viewLifecycleOwner,
        Observer<List<LeadersModel>>{leader ->
            leader.apply{leaderAdapter.differ.submitList(leader)}
        })



        teamHistoryViewModel.teamInfo.observe(viewLifecycleOwner,
        Observer<TeamsHistModel>{team ->
            team.apply {
                binding.shortName.text=team.shortName
                binding.yearOfPlay.text=team.firstYearOfPlay
                binding.leagueTv.text=team.league?.name
                binding.venueTv.text=team.venue?.name
                binding.abrvTv.text=team.abbreviation
                binding.abrvTv.text=team.clubName
                binding.offName.text=team.franchiseName


            }
        })
    }

    private fun setUpRecyclerView() {
        leaderAdapter = LeadersAdapter()
        binding.rvTeamLeaders.apply {
            adapter = leaderAdapter
            layoutManager = LinearLayoutManager(this.context)
        }
    }


}