package com.example.praktikaa.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.praktikaa.databinding.ItemCharactersBinding
import com.example.praktikaa.extension.glide
import com.example.praktikaa.model.Result

class AdapterCharacters(private var character: com.example.praktikaa.model.Character, private val onClick: (Int) ->Unit):RecyclerView.Adapter<AdapterCharacters.ViewHolderCharacters>() {

    inner class ViewHolderCharacters(private val binding: ItemCharactersBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(result: Result) {
            Log.e("aaaa", "bind: $result")
            binding.tvItemCharacter.text = result.name
            binding.tvSpecies.text = result.species
            binding.ivOfHeroes.glide(result.image)

            itemView.setOnClickListener{
                onClick(result.id)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCharacters {
        return ViewHolderCharacters(ItemCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return character.results.size
    }

    override fun onBindViewHolder(holder: ViewHolderCharacters, position: Int) {
        holder.bind(character.results[position])
    }


}