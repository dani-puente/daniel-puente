package com.example.aplicacionciudades.model.consultaApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Json.asConverterFactory("application/json".toMediaType())
object RetrofitRepository {
    val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://tuciudaddecerca-api.proconsi.com/")
            .build()
    }
}
val fichasRepo = RetrofitRepository.retrofit.create(FichasRepo::class.java)