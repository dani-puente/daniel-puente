package com.example.androidboosttraining.consulta_api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FichaDBClient {
    private val retrofit =
        Retrofit.Builder().baseUrl("https://tuciudaddecerca-api.proconsi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val service: FichaDBService = retrofit.create(FichaDBService::class.java)
}