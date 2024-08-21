package com.insa.gamelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GameAdapter(private val games: List<Game>, private val onClick: (Long) -> Unit) :
    RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idGame: TextView = itemView.findViewById(R.id.tvIdGame)
        val titleGame: TextView = itemView.findViewById(R.id.tvTitleGame)
        val imageGame: ImageView = itemView.findViewById(R.id.tvImageGame)

        init {
            itemView.setOnClickListener {
                onClick(adapterPosition.toLong())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val gameView =
            LayoutInflater.from(parent.context).inflate(R.layout.view_un_jeu, parent, false)
        return ViewHolder(gameView)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = games[position]
        holder.idGame.text = game.id.toString()
        holder.titleGame.text = game.title
        Glide.with(holder.itemView.context)
            .load(game.image)
            .into(holder.imageGame)
    }
}