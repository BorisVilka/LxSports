package com.ixsports

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.ixsports.databinding.FragmentMainBinding
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response
import java.util.*

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater,container,false)
        binding.games.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
        Client.getApi().getAns("ayna","12784-OhJLY5mb3BSOx0O","livedata","soccer").enqueue(object : retrofit2.Callback<Answer> {
            override fun onResponse(call: Call<Answer>, response: Response<Answer>) {
                Log.d("TAG","${response.body()?.games?.size ?: -1}")
                requireActivity().runOnUiThread {
                    binding.progressBar.visibility = View.INVISIBLE
                    val adapter = GamesAdapter(response.body()?.games ?: listOf())
                    binding.games.adapter = adapter
                }
            }

            override fun onFailure(call: Call<Answer>, t: Throwable) {
               t.printStackTrace()
            }

        })
        return binding.root
    }


}