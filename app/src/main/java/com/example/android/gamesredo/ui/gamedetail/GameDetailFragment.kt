package com.example.android.gamesredo.ui.gamedetail

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.example.android.gamesredo.R
import com.example.android.gamesredo.databinding.FragmentGameDetailBinding
import com.example.android.gamesredo.domain.GameDetailModel
import com.example.android.gamesredo.domain.GamePredictionModel
import com.example.android.gamesredo.domain.PlayByPlayModel
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
        val game = GameDetailFragmentArgs.fromBundle(requireArguments()).gamesPkModelArgs

        binding = FragmentGameDetailBinding.inflate(inflater)
        val homeName = game?.teams?.home?.team?.name
        val awayName = game?.teams?.away?.team?.name


        binding.gameVenue.text=game?.venue?.name
        binding.gameVenue.setTextColor(Color.parseColor(gameDetailViewModel.getPrimaryColor(homeName!!)))
        binding.statusAbstractGameState.text= game.status?.detailedState
        binding.officialDate.text= game.gamePk.toString()
        binding.awayTeamName.text= game.teams.away?.team?.name
//        binding.awayTeamName.setTextColor(Color.parseColor(gameDetailViewModel.getSecondaryColor(awayName!!)))
        binding.homeTeamName.setTextColor(Color.parseColor(gameDetailViewModel.getSecondaryColor(homeName!!)))

        gameDetailViewModel.getImg(game.gamePk!!)
        gameDetailViewModel.getImgBlurb(game.gamePk)

        gameDetailViewModel.getVidSrc(game.gamePk)

        gameDetailViewModel.getLineScore(game.gamePk ?: 663374)
//        gameDetailViewModel.getPlayByPlay(game?.gamePk ?: 663374)
//        gameDetailViewModel.getPredictions(game?.gamePk ?: 663374)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val game = GameDetailFragmentArgs.fromBundle(requireArguments()).gamesPkModelArgs

        val homeName = game?.teams?.home?.team?.name

        // vid src observer
        gameDetailViewModel.vidImg.observe(viewLifecycleOwner,
        Observer { src->
            src.apply {

                binding.videoView.setVideoPath(src)
            }
        })


//         Highlight blurb text Observer
        gameDetailViewModel.hilightText.observe(viewLifecycleOwner,
        Observer { txt ->
            txt.apply {
                binding.hilightTextBlurb.text = txt
            }
        })
//            img url observer
        gameDetailViewModel.imgsrc.observe(viewLifecycleOwner,
        Observer { img ->
            img.apply {
                Glide.with(this@GameDetailFragment)
                    .load(img)
                    .transition(withCrossFade())
                    .placeholder(R.drawable.ic_baseline_sports_handball_24)
                    .into(binding.imageView)


            }
        })
            //game line score observer
            gameDetailViewModel.gameLineScore.observe(viewLifecycleOwner,
            Observer<GameDetailModel> { gameDetail ->
                gameDetail.apply {
                   binding.awayTeamPoints.text  = gameDetail.teams2?.away2?.runs.toString() ?: "0"
                    binding.homeTeamPoints.text=gameDetail.teams2?.home2?.runs.toString()

                    binding.homeTeamErrors.text=gameDetail.teams2?.home2?.errors.toString()
                    binding.homeTeamHits.text=gameDetail.teams2?.home2?.hits.toString()

                    binding.awayTeamErrors.text=gameDetail.teams2?.away2?.errors.toString()
                    binding.homeTeamHits.text=gameDetail.teams2?.away2?.hits.toString()

                    binding.homeTeamName.text=game?.teams?.home?.team?.name
////                    +
//                            game?.teams?.home?.leagueRecord?.wins.toString() +
//                            " - " +
//                            game?.teams?.home?.leagueRecord?.losses.toString()

                    binding.currentInningOrd.text=gameDetail.currentInningOrdinal

                    binding.onDeckFullName.text = gameDetail.offense?.onDeck?.fullName
                    binding.inHoleFullName.text=gameDetail.offense?.inHole?.fullName

//                    + gameDetail.offense?.onDeck?.fullName.toString()

                    //TODO fix these
                    binding.batter.text = gameDetail.offense?.batter2?.fullName + ", " + gameDetail.offense?.team?.name
                    binding.pitcher.text = gameDetail.defense?.pitcher2?.fullName +", " + gameDetail.defense?.team?.name

                    binding.description.text = "Strikes " +gameDetail.strikes.toString() +
                                                " Balls " + gameDetail.balls.toString() +
                            " Outs "+ gameDetail.outs.toString()


                    binding.imageView.setImageURI(Uri.parse(gameDetailViewModel.imgsrc.toString()))
//                    binding.imageView.setImageURI(Uri.parse(gameDetailViewModel.getImg(game?.gamePk)))




                    when(gameDetail.isTopInning) {
                        true -> binding.inningArrowImg.setImageResource(R.drawable.ic_baseline_arrow_upward_24)
                        false -> binding.inningArrowImg.setImageResource(R.drawable.ic_baseline_arrow_downward_24)
                        else -> binding.inningArrowImg.visibility = View.INVISIBLE
                    }

                }
            })

            //game winning odds observer
//            gameDetailViewModel.gamePredictions.observe(viewLifecycleOwner,
//            Observer<GamePredictionModel> { gamePrediction ->
//                gamePrediction.apply {
//                    binding.awayTeamWinPercent.text=gamePrediction.awayWinProbability.toString()
//                    binding.homeTeamWinPercent.text=gamePrediction.homeWinProbability.toString()
//
//                }
//
//            })



    }

}