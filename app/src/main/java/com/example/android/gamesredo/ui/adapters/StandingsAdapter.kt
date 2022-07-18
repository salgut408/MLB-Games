package com.example.android.gamesredo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.gamesredo.TeamRecords
import com.example.android.gamesredo.databinding.StandingsItemBinding

class StandingsAdapter: RecyclerView.Adapter<StandingsAdapter.TeamRecordViewHolder>() {
    inner class TeamRecordViewHolder(val binding: StandingsItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<TeamRecords>() {

        override fun areItemsTheSame(oldItem: TeamRecords, newItem: TeamRecords): Boolean {
            return oldItem.team?.id == newItem.team?.id
        }

        override fun areContentsTheSame(oldItem: TeamRecords, newItem: TeamRecords): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamRecordViewHolder {
        return TeamRecordViewHolder(StandingsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: TeamRecordViewHolder, position: Int) {
        val singleRecord = differ.currentList[position]
        holder.binding.apply{
            teamName.text = singleRecord.team?.name
            season.text=singleRecord.season
            divisionRank.text=singleRecord.leagueRank
            wins.text=singleRecord.wins.toString()
            loses.text=singleRecord.losses.toString()
            winPercentage.text=singleRecord.winningPercentage
            divisionLeader.text=singleRecord.divisionLeader.toString()
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}