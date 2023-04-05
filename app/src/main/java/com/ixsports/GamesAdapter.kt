package com.ixsports

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ixsports.databinding.GameItemBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class GamesAdapter(val list: List<Game>): RecyclerView.Adapter<GamesAdapter.Companion.GameHolder>() {



    companion object {
        class GameHolder(val binding: GameItemBinding): RecyclerView.ViewHolder(binding.root) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        return GameHolder(GameItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        holder.binding.name.text = list[position].home.name
        holder.binding.name1.text = list[position].away.name
        holder.binding.textView3.text = list[position].score
        holder.binding.textView8.text = list[position].league.name
        var t = position
        Picasso.get().load(Uri.parse("https://spoyer.com/api/team_img/soccer/${list[position].home.id}.png")).into(holder.binding.photo1, object : Callback {
            override fun onSuccess() {

            }

            override fun onError(e: Exception?) {
                Picasso.get().load(Uri.parse("https://spoyer.com/api/team_img/soccer/${list[t].home.image_id}.png")).into(holder.binding.photo1, object : Callback {
                    override fun onSuccess() {

                    }

                    override fun onError(e: Exception?) {
                        Picasso.get().load(Uri.parse("https://spoyer.com/api/team_img/soccer/${list[t].league.id}.png")).into(holder.binding.photo1, object : Callback {
                            override fun onSuccess() {

                            }

                            override fun onError(e: Exception?) {
                                Picasso.get().load(Uri.parse("https://spoyer.com/api/icons/countries/${list[position].home.cc}.svg")).into(holder.binding.photo1, object : Callback {
                                    override fun onSuccess() {

                                    }

                                    override fun onError(e: Exception?) {

                                    }

                                })
                            }

                        })
                    }

                })
            }

        })
        Picasso.get().load(Uri.parse("https://spoyer.com/api/team_img/soccer/${list[position].away.id}.png")).into(holder.binding.photo2, object : Callback {
            override fun onSuccess() {

            }

            override fun onError(e: Exception?) {
                Picasso.get().load(Uri.parse("https://spoyer.com/api/team_img/soccer/${list[t].away.image_id}.png")).into(holder.binding.photo2, object : Callback {
                    override fun onSuccess() {

                    }

                    override fun onError(e: Exception?) {
                        Picasso.get().load(Uri.parse("https://spoyer.com/api/team_img/soccer/${list[t].league.id}.png")).into(holder.binding.photo2, object : Callback {
                            override fun onSuccess() {

                            }

                            override fun onError(e: Exception?) {
                                Picasso.get().load(Uri.parse("https://spoyer.com/api/icons/countries/${list[position].away.cc}.svg")).into(holder.binding.photo2, object : Callback {
                                    override fun onSuccess() {

                                    }

                                    override fun onError(e: Exception?) {

                                    }

                                })
                            }

                        })
                    }

                })
            }

        })
    }

    override fun getItemCount(): Int {
        return list.size
    }
}