package com.example.android.gamesredo.ui.allteamsroster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.gamesredo.databinding.FragmentAllTeamsInHistoryDetailBinding
import com.example.android.gamesredo.domain.RosterModel
import com.example.android.gamesredo.ui.adapters.OtherTeamsRosterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllTeamsInHistoryDetailFragment : Fragment() {

    lateinit var binding: FragmentAllTeamsInHistoryDetailBinding
    val allTeamsInHistoryRosterViewModel: AllTeamsRosterViewModel by viewModels()
    lateinit var otherTeamsRosterAdapter: OtherTeamsRosterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAllTeamsInHistoryDetailBinding.inflate(inflater)
        val allTeamsModel = AllTeamsInHistoryDetailFragmentArgs.fromBundle(requireArguments()).allTeamsTeamArg

        allTeamsInHistoryRosterViewModel.getAllTeamsRosterList(allTeamsModel?.id!!)

        setUpRecyclerView()

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpRecyclerView()

        allTeamsInHistoryRosterViewModel.allTeamsTeamRoster.observe(viewLifecycleOwner,
        Observer<List<RosterModel>> {roster ->
            roster.apply{
                otherTeamsRosterAdapter.differ.submitList(roster)
            }
        })

    }

    private fun setUpRecyclerView(){
        otherTeamsRosterAdapter = OtherTeamsRosterAdapter()
        binding.allTeamsRoster.apply {
            adapter=otherTeamsRosterAdapter
            layoutManager = LinearLayoutManager(this.context)
        }
    }

}