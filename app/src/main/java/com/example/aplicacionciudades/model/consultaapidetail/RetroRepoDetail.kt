package com.example.aplicacionciudades.model.consultaapidetail

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetroRepoDetail {
    val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://tuciudaddecerca-api.proconsi.com")
            .build()
    }
}

val detailRepo = RetroRepoDetail.retrofit.create(DetailRepo::class.java)