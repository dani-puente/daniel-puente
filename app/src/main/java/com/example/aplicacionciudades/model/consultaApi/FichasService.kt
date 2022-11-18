package com.example.aplicacionciudades.model.consultaApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FichasService {
    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://tuciudaddecerca-api.proconsi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val service: FichasRepo = retrofit.create(FichasRepo::class.java)
}