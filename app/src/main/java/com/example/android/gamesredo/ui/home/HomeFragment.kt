package com.example.android.gamesredo.ui.home

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.gamesredo.R
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
//    lateinit var divisionsListMenu: MenuItem

    val homeViewModel: HomeViewModel by viewModels()
    lateinit var standingsAdapter: StandingsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val menuHost: MenuHost = requireActivity()

        // Add menu items without using the Fragment Menu APIs
        // Note how we can tie the MenuProvider to the viewLifecycleOwner
        // and an optional Lifecycle.State (here, RESUMED) to indicate when
        // the menu should be visible
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.options_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                TODO("Not yet implemented")
            }


        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

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



//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater: MenuInflater = menuInflater
//        inflater.inflate(R.menu.options_menu, menu)
//        return true
//    }

}