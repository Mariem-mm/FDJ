package com.fdj.test.teams.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fdj.test.R
import com.fdj.test.teams.model.Team
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.teams_item.view.*

class TeamsAdapter(
    private var playersList: List<Team>?,
    private val itemClick: (Team) -> Unit
) : RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return playersList?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.teams_item, parent, false), itemClick)
    }

    fun setData(players: List<Team>?) {
        playersList = players
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        playersList?.getOrNull(position)?.let { player ->
            holder.bind(player)
        }
    }

    class ViewHolder(view: View, private val itemClick: (Team) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bind(player: Team) {
            with(player) {
                Picasso.get().load(strTeamBadge).into(itemView.imagePlayer)
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}