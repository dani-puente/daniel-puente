package com.example.aplicacionciudades.model.consultaApi

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface FichasRepo {
    @GET
    suspend fun listFichas(
        @Query("idCategoriaPadre") idCategoria: Int,
        @Query("idIdioma") idIdioma: Int,
        @Query("idProyecto") idProyecto: Int
    ): List<FichaX>
}