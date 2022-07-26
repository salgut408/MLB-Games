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
import com.bumptech.glide.Glide
import com.example.android.gamesredo.People
import com.example.android.gamesredo.Person
import com.example.android.gamesredo.R
import com.example.android.gamesredo.Team
import com.example.android.gamesredo.databinding.FragmentPersonDetailBinding
import com.example.android.gamesredo.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonDetailFragment() : Fragment() {

    lateinit var binding: FragmentPersonDetailBinding
    val personDetailViewModel: PersonDetailViewModel by viewModels()
    lateinit var person: Person
    lateinit var newPerson: People
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

        personDetailViewModel.playerInfo.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    response.data?.let {
                        peopleResponse ->
                         newPerson = peopleResponse.people[0]
                       binding.apply {
                           val second = personDetailViewModel.getPrimaryColor(team.name.toString())
                           val prim = personDetailViewModel.getSecondaryColor(team.name.toString())
                           birthday.text=newPerson.birthDate
                           position.text = newPerson.primaryPosition?.name + " " + newPerson.primaryPosition?.abbreviation
                           birthCity.text=newPerson.birthCity + ", " + newPerson.birthCountry
                           tvBatSideDesc.text=newPerson.batSide?.description
                           number.text = newPerson.primaryNumber
                           currentAge.text=newPerson.currentAge.toString()
                           heightTxt.text=newPerson.height
                           weightTxt.text=newPerson.weight.toString()
                           mlbTxt.text=newPerson.mlbDebutDate
                           teamDetName.text=team.name

                           playerInfoName.text=newPerson.firstName
                           playerInfoName.setTextColor(Color.parseColor(prim))

                         playerInfoLastName.text=newPerson.lastName
                           playerInfoLastName.setTextColor(Color.parseColor(prim))

                           playerInfoLastName.setBackgroundColor(Color.parseColor(second))
                           playerInfoName.setBackgroundColor(Color.parseColor(second))

                           personDetailViewModel.setTxtAndBgrndColor(team.name.toString(), number)
                           personDetailViewModel.setTxtAndBgrndColor(team.name.toString(), teamDetName)

                           val logo = personDetailViewModel.getLogo(team.name.toString())



//                               Glide.with(context!!.applicationContext).load(Uri.parse(logo)).into(teamLogoImg)


//                           Glide.with(Activity()).load(logo).into(teamLogoImg)
//                           Glide.with(view.context).load(logo).into(teamLogoImg)
//                           Glide.with(this@PersonDetailFragment).load(logo).into(teamLogoImg)


                       }

                    }
                }
                is Resource.Error -> {
                    response.message?.let {
                        Log.e("tag", "Resp not working")
                    }
                }
                is Resource.Loading-> {
                    Log.e("tag", "Resp not working")
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
    }

}