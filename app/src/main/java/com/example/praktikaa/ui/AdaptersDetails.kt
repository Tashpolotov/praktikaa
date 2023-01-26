package com.example.praktikaa.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.praktikaa.databinding.ItemdetailBinding
import com.example.praktikaa.extension.glide
import com.example.praktikaa.model.Result



class AdaptersDetails(private val character: com.example.praktikaa.model.Character):RecyclerView.Adapter<AdaptersDetails.ViewHolderDetail>() {


    inner class ViewHolderDetail (private val binding: ItemdetailBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(result: Result) {
            binding.imgDetail.glide(result.image)
            binding.tvRick.text = result.name
            binding.tvMaleDetail.text = result.gender
            binding.tvAlive.text = result.status
            binding.tvHuman.text = result.species
            binding.tvUnknown.text = result.type
            binding.tvEarthC137.text = result.origin.toString()
            binding.tvEarth.text = result.location.url

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDetail {
        return  ViewHolderDetail(ItemdetailBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
       return character.results.size

    }

    override fun onBindViewHolder(holder: ViewHolderDetail, position: Int) {
        holder.bind(character.results[position])


    }
}