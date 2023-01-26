package com.example.praktikaa.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praktikaa.R
import com.example.praktikaa.databinding.FragmentEpisodesBinding
import kotlinx.coroutines.NonDisposableHandle.parent


class EpisodesFragment : Fragment() {

private lateinit var binding: FragmentEpisodesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentEpisodesBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

}