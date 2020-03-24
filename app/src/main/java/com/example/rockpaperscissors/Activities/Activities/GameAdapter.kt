package com.example.rockpaperscissors.Activities.Activities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rockpaperscissors.Activities.Entities.Game
import com.example.rockpaperscissors.R
import kotlinx.android.synthetic.main.item_game.view.*

class GameAdapter(private val games: List<Game>, private val context: Context) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(game: Game){
            itemView.tvDateRv.text = game.date.toString()

            when(game.outcome){
                "Win" -> itemView.tvResultRv.text = context.getString(R.string.win_text)
                "Lose" -> itemView.tvResultRv.text = context.getString(R.string.lose_text)
                "Draw" -> itemView.tvResultRv.text = context.getString(R.string.draw_text)
                else -> print("Error, invalid outcome")
            }

            when(game.playerSet){
                GameActivity.ROCK -> itemView.ivPlayerRv.setImageResource(R.drawable.rock)
                GameActivity.PAPER -> itemView.ivPlayerRv.setImageResource(R.drawable.paper)
                GameActivity.SCISSORS -> itemView.ivPlayerRv.setImageResource(R.drawable.scissors)
                else -> print("Error, invalid set")
            }

            when(game.computerSet){
                GameActivity.ROCK -> itemView.ivComputerRv.setImageResource(R.drawable.rock)
                GameActivity.PAPER -> itemView.ivComputerRv.setImageResource(R.drawable.paper)
                GameActivity.SCISSORS -> itemView.ivComputerRv.setImageResource(R.drawable.scissors)
                else -> print("Error, invalid set")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(games[position])
    }

}