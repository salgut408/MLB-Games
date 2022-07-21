package com.example.android.gamesredo.ui.persondetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.android.gamesredo.People
import com.example.android.gamesredo.Person
import com.example.android.gamesredo.R
import com.example.android.gamesredo.databinding.FragmentPersonDetailBinding
import com.example.android.gamesredo.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonDetailFragment() : Fragment() {

    lateinit var binding: FragmentPersonDetailBinding
    val personDetailViewModel: PersonDetailViewModel by viewModels()
    lateinit var person: Person
    lateinit var newPerson: People

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPersonDetailBinding.inflate(inflater)

         person = PersonDetailFragmentArgs.fromBundle(requireArguments()).personArg
        binding.playerInfoName.text=person.fullName
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
                           birthday.text=newPerson.birthDate
                           position.text = newPerson.primaryPosition?.name + " " + newPerson.primaryPosition?.abbreviation
                           birthCity.text=newPerson.birthCity + newPerson.birthCountry
                           tvBatSideDesc.text=newPerson.batSide?.description
                           number.text = newPerson.primaryNumber


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

}