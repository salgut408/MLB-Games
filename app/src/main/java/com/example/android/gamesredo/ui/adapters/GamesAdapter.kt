package com.example.android.gamesredo.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.gamesredo.Games
import com.example.android.gamesredo.Team
import com.example.android.gamesredo.Teams
import com.example.android.gamesredo.databinding.ItemPreviewBinding

class GamesAdapter: RecyclerView.Adapter<GamesAdapter.GameViewHolder>() {
    inner class GameViewHolder(val binding: ItemPreviewBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Games>() {
        override fun areItemsTheSame(oldItem: Games, newItem: Games): Boolean {
            return oldItem.gamePk == newItem.gamePk
        }

        override fun areContentsTheSame(oldItem: Games, newItem: Games): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
      return GameViewHolder(ItemPreviewBinding.inflate(
          LayoutInflater.from(parent.context),
          parent,
          false
      ))
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
       val game = differ.currentList[position]
        holder.binding.apply {
            if(game.status?.abstractGameCode.equals("Live")) {
                awayTeam.setTextColor(Color.RED)
                homeTeam.setTextColor(Color.RED)
            } else if (game.status?.abstractGameState.equals("Preview")){
                awayTeam.setTextColor(Color.DKGRAY)
                homeTeam.setTextColor(Color.DKGRAY)
            }
            awayTeam.text = game?.teams?.away?.team?.name
            homeTeam.text = game?.teams?.home?.team?.name

//            setOnClickListener {
//                onItemClickListener?.let { it(game.teams.) }
//            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Teams)-> Unit)? = null

    fun setOnItemClickListener(listener: (Teams)->Unit) {
        onItemClickListener=listener
    }
}


































