package com.example.android.gamesredo.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.gamesredo.TeamRecords
import com.example.android.gamesredo.databinding.StandingsItemBinding
import com.example.android.gamesredo.util.Constants.Companion.img
import com.example.android.gamesredo.util.Constants.Companion.img2
import com.example.android.gamesredo.util.Constants.Companion.img3
import com.example.android.gamesredo.util.Constants.Companion.img4
import com.example.android.gamesredo.util.Constants.Companion.img5

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
            teamStandingsName.text = singleRecord.team?.name
            seasonTxt.text=singleRecord.team?.id.toString()
            divRank.text=singleRecord.divisionRank
            winsNumber.text=singleRecord.wins.toString()
            lossNumber.text=singleRecord.losses.toString()
            winPercentNumber.text=singleRecord.winningPercentage
            divisionLeaderBool.text=singleRecord?.sportRank.toString()
            // TODO use when instead or new api thing
            if (singleRecord.team?.name.equals("Chicago Cubs")){
                imageView.setImageResource(img)
            } else if (singleRecord.team?.name.equals("Chicago White Sox")){
                imageView.setImageResource(img2)

            } else if (singleRecord.team?.name.equals("New York Yankees")){
                imageView.setImageResource(img3)
                teamStandingsName.setTextColor(Color.rgb(12, 35, 64))
                teamStandingsName.setBackgroundColor(Color.rgb(196, 206, 211))

            } else if (singleRecord.team?.name.equals("Toronto Blue Jays")){
                imageView.setImageResource(img4)
                teamStandingsName.setTextColor(Color.rgb(19, 74, 142))
                teamStandingsName.setBackgroundColor(Color.rgb(232, 41, 28))
            } else if (singleRecord.team?.name.equals("Tampa Bay Rays")){
                imageView.setImageResource(img5)
                teamStandingsName.setTextColor(Color.rgb(9, 44, 92))
                teamStandingsName.setBackgroundColor(Color.rgb(143, 188, 230))
            } else if (singleRecord.team?.name.equals("Boston Red Sox")){
//                imageView.setImageResource(img6)
                teamStandingsName.setTextColor(Color.rgb(189, 48, 57))
                teamStandingsName.setBackgroundColor(Color.rgb(255, 255, 255))
            }
            else if (singleRecord.team?.name.equals("Baltimore Orioles")){
//                imageView.setImageResource(img6)
                teamStandingsName.setTextColor(Color.rgb(223, 70, 1))
                teamStandingsName.setBackgroundColor(Color.rgb(39, 37, 31))
            }



            linearLayout2.setOnClickListener {
                onItemClickListener?.let {
                    it(singleRecord)
                }
            }
        }
    }
    private var onItemClickListener: ((TeamRecords)->Unit)?=null

    fun setOnItemClickListener(listener: (TeamRecords)->Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}