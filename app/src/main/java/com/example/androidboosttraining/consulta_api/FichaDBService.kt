package com.example.androidboosttraining.consulta_api

import retrofit2.http.GET
import retrofit2.http.Query

interface FichaDBService {
    @GET("/Categoria")
    suspend fun listFichas(
        @Query("idCategoriaPadre") idCategoria: Int,
        @Query("idIdioma") idIdioma: Int,
        @Query("idProyecto") idProyecto: Int
    ): FichasDBResult
}