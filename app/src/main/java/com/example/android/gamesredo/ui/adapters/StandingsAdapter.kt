package com.example.android.gamesredo.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.gamesredo.TeamRecords
import com.example.android.gamesredo.databinding.StandingsItemBinding
import com.example.android.gamesredo.domain.StandingsModel


class StandingsAdapter : RecyclerView.Adapter<StandingsAdapter.TeamRecordViewHolder>() {
    inner class TeamRecordViewHolder(val binding: StandingsItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<StandingsModel>() {

        override fun areItemsTheSame(oldItem: StandingsModel, newItem: StandingsModel): Boolean {
            return oldItem.team?.id == newItem.team?.id
        }

        override fun areContentsTheSame(oldItem: StandingsModel, newItem: StandingsModel): Boolean {
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
        holder.binding.apply {
            teamStandingsName.text = singleRecord.team?.name
            seasonTxt.text = singleRecord.team?.id.toString()
            divRank.text = singleRecord.divisionRank
            winsNumber.text = singleRecord.wins.toString()
            lossNumber.text = singleRecord.losses.toString()
            winPercentNumber.text = singleRecord.winningPercentage
            divisionLeaderBool.text = singleRecord?.sportRank.toString()




            linearLayout2.setOnClickListener {
                onItemClickListener?.let {
                    it(singleRecord)
                }
            }
        }
    }

    private var onItemClickListener: ((StandingsModel) -> Unit)? = null

    fun setOnItemClickListener(listener: (StandingsModel) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}