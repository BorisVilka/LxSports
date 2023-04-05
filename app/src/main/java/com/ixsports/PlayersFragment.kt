package com.ixsports

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.ixsports.databinding.FragmentPlayersBinding
import retrofit2.Call
import retrofit2.Response
import java.lang.IllegalStateException


class PlayersFragment : Fragment() {


    private lateinit var binding: FragmentPlayersBinding
    private var adapter = PlayersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPlayersBinding.inflate(inflater,container,false)
        binding.games.adapter = adapter
        binding.games.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        Client.getApi().getAns("ayna","12784-OhJLY5mb3BSOx0O","livedata","soccer").enqueue(object : retrofit2.Callback<Answer> {
            override fun onResponse(call: Call<Answer>, response: Response<Answer>) {
                Log.d("TAG","${response.body()?.games?.size ?: -1}")
                for(i in response.body()!!.games) {
                    Client.getApi().getTeam("ayna","12784-OhJLY5mb3BSOx0O","squaddata",i.away.id).enqueue(object : retrofit2.Callback<TeamList> {
                        override fun onResponse(
                            call: Call<TeamList>,
                            response: Response<TeamList>
                        ) {
                           try {
                               requireActivity().runOnUiThread {
                                   binding.progressBar2.visibility = View.INVISIBLE
                                   adapter.add(response.body()!!)
                               }
                           } catch (e: IllegalStateException) {
                               e.printStackTrace()
                           }
                        }

                        override fun onFailure(call: Call<TeamList>, t: Throwable) {

                        }

                    })
                }
            }

            override fun onFailure(call: Call<Answer>, t: Throwable) {
                t.printStackTrace()
            }

        })
        return binding.root
    }


}