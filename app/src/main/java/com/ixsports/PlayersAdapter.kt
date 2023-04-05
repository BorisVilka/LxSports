package com.ixsports

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ixsports.databinding.PlayerItemBinding

class PlayersAdapter: RecyclerView.Adapter<PlayersAdapter.Companion.PlayerHolder>() {

    var data = mutableListOf<Player>()

    companion object {
        class PlayerHolder(val binding: PlayerItemBinding): RecyclerView.ViewHolder(binding.root) {}

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerHolder {
        return PlayerHolder(PlayerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
       holder.binding.namePlayer.text = data[position].name
        holder.binding.textView4.text = "Position: "+(data[position].position ?: "-")
        holder.binding.textView5.text = "Birthdate: "+data[position].birthdate
        holder.binding.textView2.text = "Number: "+(data[position].shirtnumber ?: "-")
        holder.binding.textView6.text = "Weight: "+(data[position].width ?: "-")
        holder.binding.textView7.text = "Height: "+(data[position].height ?: "-")
    }

    override fun getItemCount(): Int {
       return data.size
    }
    fun add(team: TeamList) {
        data.addAll(team.list)
        notifyItemRangeInserted(data.size-team.list.size,data.size)
    }
}