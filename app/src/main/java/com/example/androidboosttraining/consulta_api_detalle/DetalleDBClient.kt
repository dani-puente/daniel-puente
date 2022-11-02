package com.example.androidboosttraining.consulta_api_detalle

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DetalleDBClient {
    private val retrofit = Retrofit
        .Builder()
        .baseUrl("https://tuciudaddecerca-api.proconsi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(DetalleDBService::class.java)
}