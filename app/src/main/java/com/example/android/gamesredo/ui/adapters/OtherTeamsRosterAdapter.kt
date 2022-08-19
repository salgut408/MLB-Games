package com.example.android.gamesredo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.gamesredo.databinding.AllTeamsRosterItemBinding
import com.example.android.gamesredo.domain.RosterModel

class OtherTeamsRosterAdapter():
    RecyclerView.Adapter<OtherTeamsRosterAdapter.OtherTeamsRosterRowViewHolder>() {
    inner class OtherTeamsRosterRowViewHolder(val binding:AllTeamsRosterItemBinding):
            RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<RosterModel>() {
        override fun areItemsTheSame(oldItem: RosterModel, newItem: RosterModel): Boolean {
            return oldItem.person?.id == newItem.person?.id
        }

        override fun areContentsTheSame(oldItem: RosterModel, newItem: RosterModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OtherTeamsRosterRowViewHolder {
        return OtherTeamsRosterRowViewHolder(AllTeamsRosterItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: OtherTeamsRosterRowViewHolder, position: Int) {
        val singleRosterRow = differ.currentList[position]
        holder.binding.apply{
            allTeamPlayerName.text = singleRosterRow.person?.fullName
            allTeamPosition.text=singleRosterRow.jerseyNumber + " - " + singleRosterRow.position?.name
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}