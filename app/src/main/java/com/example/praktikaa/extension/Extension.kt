package com.example.praktikaa.extension

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.praktikaa.R

fun View.glide(url:String){
    Glide.with(this).load(url).placeholder(R.drawable.rick).circleCrop().into(this as ImageView)
}