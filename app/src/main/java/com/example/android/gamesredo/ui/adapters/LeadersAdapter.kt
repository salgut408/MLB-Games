package com.example.android.gamesredo.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.gamesredo.Leaders
import com.example.android.gamesredo.LeagueLeaders
import com.example.android.gamesredo.databinding.LeaderItemBinding
import com.example.android.gamesredo.domain.LeadersModel

class LeadersAdapter : RecyclerView.Adapter<LeadersAdapter.LeaderViewHolder>() {
    inner class LeaderViewHolder(val binding: LeaderItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<LeadersModel>() {
        override fun areItemsTheSame(oldItem: LeadersModel, newItem: LeadersModel): Boolean {
            return oldItem.person?.id == newItem.person?.id
        }

        override fun areContentsTheSame(oldItem: LeadersModel, newItem: LeadersModel): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderViewHolder {
        return LeaderViewHolder(LeaderItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: LeaderViewHolder, position: Int) {
        val leader = differ.currentList[position]
        holder.binding.apply {
            leaderName.text = leader.person?.fullName
            leaderTeam.text = leader.team?.name
            division.text = "Division: " + leader.league?.name
            catagoryTxt.text = "Ranking " + leader.rank.toString() + ", " + leader.value.toString()

        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

}