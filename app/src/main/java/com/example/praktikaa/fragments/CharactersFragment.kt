package com.example.praktikaa.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.praktikaa.R
import com.example.praktikaa.data.RemoteRepository
import com.example.praktikaa.databinding.FragmentCharactersBinding
import com.example.praktikaa.ui.AdapterCharacters

class CharactersFragment : Fragment() {
    @Suppress("DEPRECATION")
        private lateinit var binding: FragmentCharactersBinding
        private val repository = RemoteRepository()
        private var page = 1
        private lateinit var adapter: AdapterCharacters





    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentCharactersBinding.inflate(LayoutInflater.from(context), container, false)
        initMethod()
        initListeners()
        return binding.root

    }



    private fun initListeners() {
            binding.swaipRefresh.setOnRefreshListener{
                    ++page
                    initMethod()
                binding.swaipRefresh.isRefreshing = false


            }
            binding.nextBtn.setOnClickListener{
                ++page
                initMethod()

            }

    }

    private fun initMethod() {
            repository.getCharacters(page, this::onSuccess, this::onFailure)

    }

    private fun onSuccess(character: com.example.praktikaa.model.Character) {
        adapter = AdapterCharacters(character,this::onCLick)
        binding.rv.adapter = adapter
    }

    private fun onCLick(id:Int){
        findNavController().navigate(R.id.infoFragment)
    }

    private fun onFailure(message: String){
        Log.e("bmv", "onFailure:$message")
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_list,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    @SuppressLint("ResourceType")
    @Deprecated("Deprecated in Java", ReplaceWith(
        "super.onOptionsItemSelected(item)",
        "androidx.fragment.app.Fragment"
    )
    )
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_characters-> findNavController().navigate(R.id.infoFragment)
            R.id.menu_episodes -> findNavController().navigate(R.id.episodesFragment)
            R.id.menu_locations -> findNavController().navigate(R.id.locationsFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}
