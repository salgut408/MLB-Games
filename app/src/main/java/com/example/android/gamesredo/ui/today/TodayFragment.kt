package com.example.android.gamesredo.ui.today

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android.gamesredo.MlbColors
import com.example.android.gamesredo.R
import com.example.android.gamesredo.util.Resource
import com.example.android.gamesredo.databinding.FragmentTodayBinding
import com.example.android.gamesredo.db.VenueDatabase
import com.example.android.gamesredo.repository.GameRepository
import com.example.android.gamesredo.ui.adapters.GamesAdapter
import com.example.android.gamesredo.util.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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
        savedInstanceState: Bundle?
    ): View {
//        val gameRepository = GameRepository(VenueDatabase(context?.applicationContext!!))
//        val viewModelProviderFactory = TodayVMProviderFactory(gameRepository)
//        todayViewModel = ViewModelProvider(this, viewModelProviderFactory).get(TodayViewModel::class.java)


        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root


    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.todaysDate?.text = setDate()


        setUpRecyclerView()



        todayViewModel.allGames.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { mlbresponse ->
                        gameAdapter.differ.submitList(mlbresponse.dates[0].games)
                    }
                }
                is Resource.Error -> {
                    response.message?.let { message ->
                        Log.e("Tag", "response not successfull")
                    }
                }
                is Resource.Loading -> {
                    hideProgressBar()
                }
            }

        })
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    private fun setUpRecyclerView(){
        gameAdapter = GamesAdapter()
        binding.rvGames.apply {
            adapter = gameAdapter
            layoutManager = GridLayoutManager(this.context, 2)
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






































