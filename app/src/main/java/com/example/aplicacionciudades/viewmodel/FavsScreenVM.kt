package com.example.aplicacionciudades.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacionciudades.model.consultaapimain.FichaX
import com.example.aplicacionciudades.model.consultaapimain.RetroRepoFicha
import com.example.aplicacionciudades.model.database.dao.FavDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavsScreenVM @Inject constructor(
    private val favDao: FavDao,
    retroRepoFicha: RetroRepoFicha
) : ViewModel(), CoroutineScope {
    override val coroutineContext = viewModelScope.coroutineContext
    private val _fichas = MutableStateFlow<List<FichaX>>(emptyList())
    val fichas = _fichas.asStateFlow()

    init {
        launch {
            try {
                val fichas = retroRepoFicha.getFichas()
                val entities = favDao.listarFavoritos()
                val fichasFav: MutableList<FichaX> = mutableListOf()
                for (ficha in fichas){
                    for (entity in entities){
                        if (ficha.idFicha == entity.idFicha){
                            fichasFav.add(ficha)
                        }
                    }
                }
                _fichas.value = fichasFav
            } catch (ignore: Throwable) {
                Log.e("error", "Entro en el error")
            }
        }
    }
}