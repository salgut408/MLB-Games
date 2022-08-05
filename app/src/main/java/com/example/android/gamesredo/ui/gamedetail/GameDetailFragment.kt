package com.example.android.gamesredo.ui.gamedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.android.gamesredo.R
import com.example.android.gamesredo.databinding.FragmentGameDetailBinding
import com.example.android.gamesredo.domain.GameDetailModel
import com.example.android.gamesredo.domain.GamePredictionModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class GameDetailFragment : Fragment() {
    lateinit var binding: FragmentGameDetailBinding
    val gameDetailViewModel: GameDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameDetailBinding.inflate(inflater)
        val game = GameDetailFragmentArgs.fromBundle(requireArguments()).gamesPkModelArgs
        binding.gameVenue.text=game?.venue?.name
        binding.statusAbstractGameState.text=game?.status?.detailedState
        binding.officialDate.text=game?.gamePk.toString()
        binding.awayTeamName.text=game?.teams?.away?.team?.name

        gameDetailViewModel.getLineScore(game?.gamePk ?: 0)
        gameDetailViewModel.getPredictions(game?.gamePk ?: 0)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val game = GameDetailFragmentArgs.fromBundle(requireArguments()).gamesPkModelArgs
            gameDetailViewModel.gameLineScore.observe(viewLifecycleOwner,
            Observer<GameDetailModel> { gameDetail ->
                gameDetail.apply {
                   binding.awayTeamPoints.text  = gameDetail.teams2?.away2?.runs.toString()
                    binding.homeTeamPoints.text=gameDetail.teams2?.home2?.runs.toString()
                    binding.homeTeamName.text=game?.teams?.home?.team?.name
                }
            })

            gameDetailViewModel.gamePredictions.observe(viewLifecycleOwner,
            Observer<GamePredictionModel> { gamePrediction ->
                gamePrediction.apply {
                    binding.awayTeamWinPercent.text=gamePrediction.awayWinProbability.toString()
                    binding.homeTeamWinPercent.text=gamePrediction.homeWinProbability.toString()

                }

            })



    }

}