package com.example.aplicacionciudades.model.consultaApiDetail

import com.example.aplicacionciudades.di.Url
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RetroRepoDetail @Inject constructor(private val repo: DetailRepo) {

    suspend fun getDetail(idFicha: Int): Detail {
        return withContext(Dispatchers.IO) {
            val response = repo.getDetail(
                idFicha,
                Url.tipoFicha,
                Url.idIdioma,
                Url.idProyecto
            )
            response
        }
    }
}