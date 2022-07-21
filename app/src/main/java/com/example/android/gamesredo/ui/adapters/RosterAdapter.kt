package com.example.android.gamesredo.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.gamesredo.Person
import com.example.android.gamesredo.Roster
import com.example.android.gamesredo.databinding.RosterItemBinding

class RosterAdapter: RecyclerView.Adapter<RosterAdapter.RosterRowViewHolder>() {
    inner class RosterRowViewHolder(val binding: RosterItemBinding): RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Roster>() {

        override fun areItemsTheSame(oldItem: Roster, newItem: Roster): Boolean {
            return oldItem.person?.id == newItem.person?.id
        }

        override fun areContentsTheSame(oldItem: Roster, newItem: Roster): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RosterRowViewHolder {
        return RosterRowViewHolder(RosterItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: RosterRowViewHolder, position: Int) {
        val singlePlayerRow = differ.currentList[position]
        holder.binding.apply {
            playerName.text = singlePlayerRow.person?.fullName
            positionText.text=singlePlayerRow?.position?.name
            playerNumber.text=singlePlayerRow?.jerseyNumber.toString()
            positionAbv.text=singlePlayerRow?.position?.abbreviation
            playerId.text=singlePlayerRow?.person?.id?.toString()


            if (position % 2 == 0 && singlePlayerRow?.parentTeamId == 147){
                card.setCardBackgroundColor(Color.rgb(12, 35, 64))
            } else {
                card.setCardBackgroundColor(Color.rgb(196, 206, 211))
            }

            playerName.setOnClickListener {
                onItemClickListener?.let {
                    it(singlePlayerRow.person!!)
                }
            }

        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Person)->Unit)?=null

    fun setOnItemClickListener(listener:(Person)->Unit) {
        onItemClickListener = listener
    }


}