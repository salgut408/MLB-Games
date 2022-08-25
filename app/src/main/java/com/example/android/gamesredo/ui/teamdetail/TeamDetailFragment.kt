package com.example.android.gamesredo.ui.teamdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.gamesredo.databinding.FragmentTeamDetailBinding
import com.example.android.gamesredo.domain.RosterModel
import com.example.android.gamesredo.ui.adapters.RosterAdapter
import com.example.android.gamesredo.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamDetailFragment() : Fragment() {
    lateinit var binding: FragmentTeamDetailBinding
    val teamDetailViewModel: TeamDetailViewModel by viewModels()
    lateinit var rosterAdapter: RosterAdapter
    lateinit var primaryColor: String
    lateinit var secondaryColor: String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTeamDetailBinding.inflate(inflater)
        val teamRecords = TeamDetailFragmentArgs.fromBundle(requireArguments()).teamRecordsArgs



        binding.textView.text = teamRecords.team?.name


        teamDetailViewModel.getRoster(teamRecords?.team?.id ?: 0)

        primaryColor = teamDetailViewModel.getPrimaryColor(teamRecords.team?.name.toString())
        secondaryColor = teamDetailViewModel.getSecondaryColor(teamRecords.team?.name.toString())

        setUpRecyclerView(primaryColor, secondaryColor)

//        rosterAdapter.setOnItemClickListener {
//            this.findNavController().navigate(
//                TeamDetailFragmentDirections.actionTeamDetailToPersonDetailFragment(it)
//            )
//        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView(primaryColor, secondaryColor)
        val teamRecords = TeamDetailFragmentArgs.fromBundle(requireArguments()).teamRecordsArgs

        teamDetailViewModel.setTxtAndBgrndColor(teamRecords.team?.name.toString(), binding.textView)
        //SETS COLOR BEHIND REC. VIEW
//        view.setBackgroundColor(Color.parseColor(teamDetailViewModel.getPrimaryColor(teamRecords.team?.name.toString())))


        rosterAdapter.setOnItemClickListener {
            this.findNavController().navigate(
                TeamDetailFragmentDirections.actionTeamDetailToPersonDetailFragment(it,
                    teamRecords.team)
            )
        }

        teamDetailViewModel.teamRoster.observe(viewLifecycleOwner,
            Observer<List<RosterModel>> { roster ->
                roster.apply { rosterAdapter.differ.submitList(roster) }
            })


    }


    private fun setUpRecyclerView(color1: String, color2: String) {
        rosterAdapter = RosterAdapter(color1, color2)
        binding.rvRoster.apply {
            adapter = rosterAdapter
            layoutManager = LinearLayoutManager(this.context)

        }
    }



}