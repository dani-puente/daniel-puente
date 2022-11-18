package com.example.aplicacionciudades.viewmodel

import androidx.lifecycle.ViewModel
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.model.consultaApi.FichaX
import com.example.aplicacionciudades.model.consultaApi.FichasService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class MAViewModel : ViewModel() {
    private val _viewState = MutableStateFlow(emitirFichas())
    val fichas: StateFlow<FichaX>
        get() = _viewState

    private fun emitirFichas() = flow {
        val fichasService = FichasService.service.listFichas(
            R.integer.idCategoriaPadre,
            R.integer.idIdioma,
            R.integer.idProyecto
        )
        for (i in fichasService){
            emit(i)
        }
    }


}