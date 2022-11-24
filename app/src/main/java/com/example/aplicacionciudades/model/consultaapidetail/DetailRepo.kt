package com.example.aplicacionciudades.model.consultaapidetail

import retrofit2.http.GET
import retrofit2.http.Query

interface DetailRepo {
    @GET("/ficha")
    suspend fun detail(
        @Query("idFicha") idFicha: Int,
        @Query("TipoFicha") TipoFicha: Int,
        @Query("idIdioma") idIdioma: Int,
        @Query("idProyecto") idProyecto: Int
    ): Detail
}