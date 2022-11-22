package com.example.aplicacionciudades.model.consultaApi

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Json.asConverterFactory("application/json".toMediaType())
object FichasService {
    val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://tuciudaddecerca-api.proconsi.com/")
            .build()
            .create(FichasRepo::class.java)
    }

}