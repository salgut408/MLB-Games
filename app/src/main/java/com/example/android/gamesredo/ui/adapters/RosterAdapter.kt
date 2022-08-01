package com.example.android.gamesredo.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.alpha
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.gamesredo.Person
import com.example.android.gamesredo.Roster
import com.example.android.gamesredo.databinding.RosterItemBinding
import com.example.android.gamesredo.domain.RosterModel
import com.example.android.gamesredo.ui.teamdetail.TeamDetailViewModel

class RosterAdapter(val colorPrimary: String, val colorSecondary: String) :
    RecyclerView.Adapter<RosterAdapter.RosterRowViewHolder>() {
    inner class RosterRowViewHolder(val binding: RosterItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<RosterModel>() {

        override fun areItemsTheSame(oldItem: RosterModel, newItem: RosterModel): Boolean {
            return oldItem.person?.id == newItem.person?.id
        }

        override fun areContentsTheSame(oldItem: RosterModel, newItem: RosterModel): Boolean {
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
            positionText.text = singlePlayerRow?.position?.name
            playerNumber.text = singlePlayerRow?.jerseyNumber.toString()
            positionAbv.text = singlePlayerRow?.position?.abbreviation
            playerId.text = singlePlayerRow?.person?.id?.toString()

            playerName.setBackgroundColor(Color.WHITE)
//TODO fix color assignment


            if (position % 2 == 0) {
                card.setCardBackgroundColor(Color.parseColor(colorPrimary))

            } else {
                card.setCardBackgroundColor(Color.parseColor(colorSecondary))
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

    private var onItemClickListener: ((Person) -> Unit)? = null

    fun setOnItemClickListener(listener: (Person) -> Unit) {
        onItemClickListener = listener
    }


}