package com.example.android.gamesredo.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.gamesredo.*
import com.example.android.gamesredo.databinding.ItemPreviewBinding
import com.example.android.gamesredo.domain.GamesModel
import com.example.android.gamesredo.ui.today.TodayViewModel

class GamesAdapter(val colors: List<MlbColors>) : RecyclerView.Adapter<GamesAdapter.GameViewHolder>() {
    inner class GameViewHolder(val binding: ItemPreviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<GamesModel>() {
        override fun areItemsTheSame(oldItem: GamesModel, newItem: GamesModel): Boolean {
            return oldItem.gamePk == newItem.gamePk
        }

        override fun areContentsTheSame(oldItem: GamesModel, newItem: GamesModel): Boolean {
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
            awayTeam.text = game?.teams?.away?.team?.name +", "+ game?.teams?.away?.score
            homeTeam.text = game?.teams?.home?.team?.name +", "+ game?.teams?.home?.score



            for (i in colors) {
                if(i.name!!.equals(game.teams?.away?.team?.name )) {
                    awayTeam.setTextColor(Color.parseColor(i.colors?.primary))
                    awayTeam.setBackgroundColor(Color.parseColor(i.colors?.secondary))


                }
                if(i.name!!.equals(game.teams?.home?.team?.name )) {

                    homeTeam.setTextColor(Color.parseColor(i.colors?.primary))
                    homeTeam.setBackgroundColor(Color.parseColor(i.colors?.secondary))

                }
            }


//            for(team in colorList) {
//                if (game?.teams?.away?.team?.name == team.mlbColors[0].name) {
//                    awayTeam.setTextColor(Color.parseColor(team.mlbColors[0].colors?.primary))
//                } else if (game?.teams?.home?.team?.name == team.mlbColors[0].name) {
//                    homeTeam.setTextColor(Color.parseColor(team.mlbColors[0].colors?.primary))
//                }
//            }

            setOnItemClickListener {
                onItemClickListener?.let { it(game) }
            }

        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((GamesModel) -> Unit)? = null

    fun setOnItemClickListener(listener: (GamesModel) -> Unit) {
        onItemClickListener = listener
    }
}


































