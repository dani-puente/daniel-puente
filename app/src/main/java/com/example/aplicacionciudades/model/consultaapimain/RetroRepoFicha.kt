package com.example.aplicacionciudades.model.consultaapimain

import com.example.aplicacionciudades.ui.viewmodel.ResourcesObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

//Json.asConverterFactory("application/json".toMediaType())
class RetroRepoFicha @Inject constructor(private val repo: FichasRepo) {

    suspend fun getFichas(): List<FichaX>{
        return withContext(Dispatchers.IO){
            val response = repo.listFichas(
                ResourcesObject.idCategoriaPadre,
                ResourcesObject.idIdioma,
                ResourcesObject.idProyecto
            )
            response.fichas
        }
    }
//    val retrofit by lazy {
//        Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl("https://tuciudaddecerca-api.proconsi.com/")
//            .build()
//    }
}
//val fichasRepo = RetroRepoFicha.retrofit.create(FichasRepo::class.java)