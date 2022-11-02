package com.example.androidboosttraining.consulta_api_detalle

import retrofit2.http.GET
import retrofit2.http.Query

interface DetalleDBService {
    @GET("/Ficha")
    suspend fun mostrarDetalle(
        @Query("idFicha") idFicha: Int,
        @Query("TipoFicha") TipoFicha: String,
        @Query("idIdioma") idIdioma: Int,
        @Query("idProyecto") idProyecyo: Int
    ): SubFicha
}