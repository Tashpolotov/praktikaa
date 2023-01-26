package com.example.praktikaa.data

import com.example.praktikaa.model.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository() {

    fun getCharacters(page:Int, returnOnSuccess:(Character)-> Unit,
                      returnOnFalure: (String) -> Unit ){

        RetrofitClient.api.getCharacters(page).enqueue(object : Callback<com.example.praktikaa.model.Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                if (response.isSuccessful)
                    returnOnSuccess(response.body()!!)
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                    returnOnFalure(t.message?: "Unknown Error")
            }

        })
    }
}