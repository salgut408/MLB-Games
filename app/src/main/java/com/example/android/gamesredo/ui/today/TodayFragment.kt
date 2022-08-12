package com.example.android.gamesredo.ui.today

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.gamesredo.databinding.FragmentTodayBinding
import com.example.android.gamesredo.domain.GamesModel
import com.example.android.gamesredo.notifications.services.ScoreNotificationService
import com.example.android.gamesredo.ui.adapters.GamesAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class TodayFragment : Fragment() {

    private var _binding: FragmentTodayBinding? = null
    private val binding get() = _binding!!
    val todayViewModel: TodayViewModel by viewModels()

    lateinit var gameAdapter: GamesAdapter




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root


    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val service = ScoreNotificationService(this.context!!)


        _binding?.todaysDate?.text = setDate()


        // notification atm TODO update
//        _binding?.baseballimage?.setOnClickListener {
//            service.showNotification(Counter.value)
//        }



        setUpRecyclerView()

        gameAdapter.setOnItemClickListener {
            this.findNavController().navigate(
                TodayFragmentDirections.actionNavigationDashboardToGameDetail(it)
            )
        }

        todayViewModel.allGames.observe(viewLifecycleOwner, Observer<List<GamesModel>> { game ->
            game.apply {

                gameAdapter.differ.submitList(game)
            }
        })

    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    private fun setUpRecyclerView( ) {
        val colors  = todayViewModel.colors
        val service = ScoreNotificationService(this.context!!)

        gameAdapter = GamesAdapter(colors!!)
        binding.rvGames.apply {
            adapter = gameAdapter
            layoutManager = LinearLayoutManager(this.context)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setDate(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val formatted = current.format(formatter)
        return formatted
    }

}






































