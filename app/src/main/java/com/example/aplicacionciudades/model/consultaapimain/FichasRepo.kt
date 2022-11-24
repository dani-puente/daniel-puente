package com.example.aplicacionciudades.model.consultaapimain

import retrofit2.http.GET
import retrofit2.http.Query

interface FichasRepo {
    @GET("Categoria")
    suspend fun listFichas(
        @Query("idCategoriaPadre") idCategoria: Int,
        @Query("idIdioma") idIdioma: Int,
        @Query("idProyecto") idProyecto: Int
    ): Ficha
}