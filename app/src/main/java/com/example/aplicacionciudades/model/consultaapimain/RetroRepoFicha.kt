package com.example.aplicacionciudades.model.consultaapimain

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Json.asConverterFactory("application/json".toMediaType())
object RetroRepoFicha {
    val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://tuciudaddecerca-api.proconsi.com/")
            .build()
    }
}
val fichasRepo = RetroRepoFicha.retrofit.create(FichasRepo::class.java)