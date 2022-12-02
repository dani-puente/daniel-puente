package com.example.aplicacionciudades.model.consultaapidetail

import com.example.aplicacionciudades.viewmodel.ResourcesObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RetroRepoDetail @Inject constructor(private val repo: DetailRepo) {

    suspend fun getDetail(idFicha: Int): Detail {
        return withContext(Dispatchers.IO) {
            val response = repo.getDetail(
                idFicha,
                ResourcesObject.tipoFicha,
                ResourcesObject.idIdioma,
                ResourcesObject.idProyecto
            )
            response
        }
    }
//    val retrofit by lazy {
//        Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("https://tuciudaddecerca-api.proconsi.com")
//            .build()
//    }
}

//val detailRepo = RetroRepoDetail.retrofit.create(DetailRepo::class.java)