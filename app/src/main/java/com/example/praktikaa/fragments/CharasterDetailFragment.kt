package com.example.praktikaa.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.praktikaa.R
import com.example.praktikaa.data.RemoteRepository
import com.example.praktikaa.databinding.FragmentCharasterDetailBinding
import com.example.praktikaa.ui.AdapterCharacters
import com.example.praktikaa.ui.AdaptersDetails


class CharasterDetailFragment : Fragment() {

    private lateinit var binding: FragmentCharasterDetailBinding
    private val repository = RemoteRepository()
    private lateinit var adapter: AdaptersDetails
    private var page = 1



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCharasterDetailBinding.inflate(LayoutInflater.from(context), container, false)
        initMethod()
        initListeners()
        return binding.root
    }




    private fun initMethod() {
        repository.getCharacters(page, this::onSuccess, this::onFailure)

    }

    private fun initListeners() {
        binding.nextBtn.setOnClickListener {
            ++page
            initMethod()
        }

    }


    private fun onSuccess(character: com.example.praktikaa.model.Character) {
        adapter = AdaptersDetails(character)
        binding.rv.adapter = adapter

    }



    private fun onFailure(message: String){
        Log.e("bmv", "onFailure:$message")
    }

}