package com.example.android.gamesredo.ui.leaders

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.gamesredo.databinding.FragmentNotificationsBinding
import com.example.android.gamesredo.ui.adapters.LeadersAdapter
import com.example.android.gamesredo.ui.adapters.StandingsAdapter
import com.example.android.gamesredo.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LeadersFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    val leadersViewModel: LeadersViewModel by viewModels()

    lateinit var leadersAdapter: LeadersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpRecyclerView()

        leadersViewModel.allLeaders.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let { leagueLeaderResponse ->
                        val list = leagueLeaderResponse.leagueLeaders[0].leaders
                        leadersAdapter.differ.submitList(list)
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Log.e("tag", "resp not successful")
                    }
                }
                is Resource.Loading -> {
                    Log.e("tag", "Resp loading")
                }
            }
        })

    }

    private fun setUpRecyclerView() {
        leadersAdapter = LeadersAdapter()
      binding.rvLeaders.apply {
           adapter = leadersAdapter
           layoutManager = LinearLayoutManager(this.context)
       }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}