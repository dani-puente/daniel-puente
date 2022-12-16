package com.example.aplicacionciudades.model.consultaApiMain

import com.example.aplicacionciudades.di.Url
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RetroRepoFicha @Inject constructor(private val repo: FichasRepo) {

    suspend fun getFichas(): List<FichaX>{
        return withContext(Dispatchers.IO){
            val response = repo.listFichas(
                Url.idCategoriaPadre,
                Url.idIdioma,
                Url.idProyecto
            )
            response.fichas
        }
    }
}