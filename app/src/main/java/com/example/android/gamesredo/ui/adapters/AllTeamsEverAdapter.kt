package com.example.android.gamesredo.ui.adapters

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.gamesredo.databinding.AllTeamsItemBinding
import com.example.android.gamesredo.domain.AllTeamModel

class AllTeamsEverAdapter: RecyclerView.Adapter<AllTeamsEverAdapter.TeamViewHolder>() {
    inner class TeamViewHolder(val binding: AllTeamsItemBinding):
    RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<AllTeamModel>() {
        override fun areItemsTheSame(oldItem: AllTeamModel, newItem: AllTeamModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AllTeamModel, newItem: AllTeamModel): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(AllTeamsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = differ.currentList[position]
        holder.binding.apply {

            if(team.parentOrgName.isNullOrBlank()){
                parentOrgTxt.visibility = View.GONE
                parentDisplayTxt.visibility = View.GONE
            }

            if(team.division?.name.isNullOrBlank()){
                divisionName.visibility = View.GONE
                divisionDisplayTxt.visibility = View.GONE
            }

            if(team.league?.name.isNullOrBlank()){
                leagueName.visibility = View.GONE
                leagueDisplayTxt.visibility = View.GONE
            }

            allTeamsTeamName.text= team.franchiseName ?: team.teamName
            allTeamsTeamClubName.text = team.clubName ?: team.name
            leagueName.text = team.league?.name
            divisionName.text = team.division?.name
            parentOrgTxt.text = team.parentOrgName
            isActiveTxt.text=team.active.toString()
            venueTxt.text = team.venue?.name
            abrv.text = team.abbreviation
//            + team.league?.name + " "+ team.league?.id +" "+ team.parentOrgName+ " " + team.active
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}