package com.example.android.gamesredo.ui.persondetail

import android.app.Activity
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.android.gamesredo.*
import com.example.android.gamesredo.databinding.FragmentPersonDetailBinding
import com.example.android.gamesredo.domain.PeopleModel
import com.example.android.gamesredo.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonDetailFragment() : Fragment() {

    lateinit var binding: FragmentPersonDetailBinding
    val personDetailViewModel: PersonDetailViewModel by viewModels()
    lateinit var person: Person
    lateinit var team: Team


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPersonDetailBinding.inflate(inflater)

        person = PersonDetailFragmentArgs.fromBundle(requireArguments()).personArg

        team = PersonDetailFragmentArgs.fromBundle(requireArguments()).teamArgs!!


        personDetailViewModel.getPersonInfo(person.id!!.toInt())

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        personDetailViewModel.playerInfo.observe(viewLifecycleOwner,
            Observer<PeopleModel> { people ->
                people.apply {
                    val second = personDetailViewModel.getPrimaryColor(team.name.toString())
                    val prim = personDetailViewModel.getSecondaryColor(team.name.toString())
                    binding.birthday.text = people.birthDate
                    binding.position.text =
                        people.primaryPosition?.name + " " + people.primaryPosition?.abbreviation

                    binding.birthCity.text = people.birthCity + ", " + people.birthCountry
                    binding.tvBatSideDesc.text = people.batSide?.description
                    binding.number.text = people.primaryNumber
                    binding.currentAge.text = people.currentAge.toString()
                    binding.heightTxt.text = people.height
                    binding.weightTxt.text = people.weight.toString()
                    binding.mlbTxt.text = people.mlbDebutDate
                    binding.teamDetName.text = team.name

                    binding.playerInfoName.text = people.firstName
                    binding.playerInfoName.setTextColor(Color.parseColor(prim))

                    binding.playerInfoLastName.text = people.lastName
                    binding.playerInfoLastName.setTextColor(Color.parseColor(prim))

                    binding.playerInfoLastName.setBackgroundColor(Color.parseColor(second))
                    binding.playerInfoName.setBackgroundColor(Color.parseColor(second))


                    personDetailViewModel.setTxtAndBgrndColor(team.name.toString(), binding.number)
                    personDetailViewModel.setTxtAndBgrndColor(team.name.toString(),
                        binding.teamDetName)

                        binding.teamDetName.setOnClickListener {
                            onItemClickListener.let {
                                this@PersonDetailFragment.findNavController().navigate(
                                    PersonDetailFragmentDirections.actionPersonDetailFragmentToTeamHistoryFragment( team)
                                )
                            }
                        }
                }
            })

        // make glide work
//        Glide.with(context!!.applicationContext).load(personDetailViewModel.getLogo(team.name.toString())).into(binding.teamLogoImg)


    }
    private var onItemClickListener: ((Team) -> Unit)? = null
//
//    fun setOnItemClickListener(listener: (Team) -> Unit) {
//        onItemClickListener = listener
//    }

    override fun onResume() {
        super.onResume()
    }



}