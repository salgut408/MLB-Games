package com.example.android.gamesredo.ui.teamdetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.gamesredo.R
import com.example.android.gamesredo.Team
import com.example.android.gamesredo.databinding.FragmentTeamDetailBinding
import com.example.android.gamesredo.ui.adapters.RosterAdapter
import com.example.android.gamesredo.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamDetailFragment() : Fragment() {
    lateinit var binding: FragmentTeamDetailBinding
    val teamDetailViewModel: TeamDetailViewModel by viewModels()
     lateinit var rosterAdapter: RosterAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentTeamDetailBinding.inflate(inflater)
        val teamRecords = TeamDetailFragmentArgs.fromBundle(requireArguments()).teamRecordsArgs

        binding.textView.text=teamRecords.team?.id.toString() + teamRecords.team?.name

        teamDetailViewModel.getRoster(teamRecords?.team?.id ?: 0)
        setUpRecyclerView()

//        rosterAdapter.setOnItemClickListener {
//            this.findNavController().navigate(
//                TeamDetailFragmentDirections.actionTeamDetailToPersonDetailFragment(it)
//            )
//        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        rosterAdapter.setOnItemClickListener {
            this.findNavController().navigate(
                TeamDetailFragmentDirections.actionTeamDetailToPersonDetailFragment(it)
            )
        }

        teamDetailViewModel.teamRoster.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        teamRosterResponse ->
                        val roster = teamRosterResponse.roster
                        rosterAdapter.differ.submitList(roster)
                    }
                }
                is Resource.Error -> {
                    response.message?.let{
                        Log.e("tag", "resp not successfull")
                    }
                }
                is Resource.Loading -> {
                    Log.e("tag", "resp to loading")
                }
            }
        })

    }


    private fun setUpRecyclerView() {
        rosterAdapter = RosterAdapter()
        binding.rvRoster.apply {
            adapter = rosterAdapter
            layoutManager=LinearLayoutManager(this.context)
        }
    }

//    private fun callRoster(teamId: Int, vm: TeamDetailViewModel) {
//        vm.getRoster(teamId)
//    }
}