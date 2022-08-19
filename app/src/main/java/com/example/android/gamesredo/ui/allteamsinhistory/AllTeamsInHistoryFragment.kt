package com.example.android.gamesredo.ui.allteamsinhistory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.gamesredo.databinding.FragmentAllTeamsInHistoryBinding
import com.example.android.gamesredo.domain.AllTeamModel
import com.example.android.gamesredo.ui.adapters.AllTeamsEverAdapter
import com.example.android.gamesredo.ui.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllTeamsInHistoryFragment : Fragment() {

    lateinit var binding: FragmentAllTeamsInHistoryBinding
    val allTeamsInHistoryViewModel: AllTeamsInHistoryViewModel by viewModels()
    lateinit var allTeamsEverAdapter: AllTeamsEverAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentAllTeamsInHistoryBinding.inflate(inflater)

//        val root: View = binding.root
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpRecyclerView()


        allTeamsEverAdapter.setOnItemClickListener {
            this.findNavController().navigate(
                AllTeamsInHistoryFragmentDirections.actionAllTeamsInHistoryFragmentToAllTeamsInHistoryDetailFragment(it)
            )
        }


        allTeamsInHistoryViewModel.allTeamsEver.observe(viewLifecycleOwner,
        Observer<List<AllTeamModel>> { teams ->
            teams.apply{
                allTeamsEverAdapter.differ.submitList(teams)
            }
        })
    }




    private fun setUpRecyclerView(){
        allTeamsEverAdapter = AllTeamsEverAdapter()
        binding.allTeamsRecView.apply {
            adapter = allTeamsEverAdapter
            layoutManager = LinearLayoutManager(this.context)
        }
    }


}