package com.example.android.gamesredo.ui.teamhistory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.android.gamesredo.R
import com.example.android.gamesredo.Team
import com.example.android.gamesredo.databinding.FragmentTeamHistoryBinding
import com.example.android.gamesredo.domain.TeamsHistModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamHistoryFragment : Fragment() {

    lateinit var binding: FragmentTeamHistoryBinding
    val teamHistoryViewModel: TeamHistoryViewModel by viewModels()
    lateinit var team: Team

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        teamHistoryViewModel.teamInfo.observe(viewLifecycleOwner,
        Observer<TeamsHistModel>{team ->
            team.apply {
                binding.txtview.text = team.shortName.toString()
            }
        })
    }


}