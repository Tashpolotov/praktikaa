package com.example.praktikaa.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.praktikaa.R
import com.example.praktikaa.databinding.FragmentLocationsBinding

class LocationsFragment : Fragment() {

    private lateinit var binding: FragmentLocationsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLocationsBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

}