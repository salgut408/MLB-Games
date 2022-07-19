package com.example.android.gamesredo.ui.teamdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.gamesredo.R
import com.example.android.gamesredo.databinding.FragmentTeamDetailBinding


class TeamDetailFragment : Fragment() {
    lateinit var binding: FragmentTeamDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding=FragmentTeamDetailBinding.inflate(inflater)
        val teamRecords = TeamDetailFragmentArgs.fromBundle(requireArguments()).teamRecordsArgs
        binding.textView.text=teamRecords.team?.name
        return binding.root
    }


}