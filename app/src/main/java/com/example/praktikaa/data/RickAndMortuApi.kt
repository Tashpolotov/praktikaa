package com.example.praktikaa.data

import com.example.praktikaa.model.Character
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortuApi {

        @GET("/api/character/")
        fun getCharacters(
            @Query("page") page: Int): Call<Character>
}