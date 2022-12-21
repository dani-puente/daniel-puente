package com.example.aplicacionciudades.model.consultaApiDetail

import retrofit2.http.GET
import retrofit2.http.Query

interface DetailRepo {
    @GET("/ficha")
    suspend fun getDetail(
        @Query("idFicha") idFicha: Int,
        @Query("TipoFicha") TipoFicha: String,
        @Query("idIdioma") idIdioma: Int,
        @Query("idProyecto") idProyecto: Int
    ): Detail
}