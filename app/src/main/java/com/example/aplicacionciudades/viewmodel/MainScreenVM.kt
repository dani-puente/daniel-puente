package com.example.aplicacionciudades.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacionciudades.model.consultaapimain.FichaX
import com.example.aplicacionciudades.model.consultaapimain.fichasRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainScreenVM : ViewModel() {

    private val _fichas = MutableStateFlow<List<FichaX>>(emptyList())
    val fichas = _fichas.asStateFlow()

    fun init() {
        listarFichas()
    }

    private fun listarFichas() {
        viewModelScope.launch {
            val fichasService = fichasRepo.listFichas(
                ResourcesObject.idCategoriaPadre,
                ResourcesObject.idIdioma,
                ResourcesObject.idProyecto
            )
            _fichas.value = fichasService.fichas
        }
    }
}



