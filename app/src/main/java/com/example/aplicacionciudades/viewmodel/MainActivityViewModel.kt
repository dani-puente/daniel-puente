package com.example.aplicacionciudades.viewmodel

import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacionciudades.model.consultaapidetail.detailRepo
import com.example.aplicacionciudades.model.consultaapimain.FichaX
import com.example.aplicacionciudades.model.consultaapimain.fichasRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
//    private val _idFicha = MutableStateFlow<Int?>(null)
//    private val idFicha: StateFlow<Int?> get() = _idFicha

    private val _fichas = MutableStateFlow<List<FichaX>>(emptyList())
    val fichas: StateFlow<List<FichaX>> get() = _fichas

    init {
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
//    private fun getDetalle(){
//        viewModelScope.launch {
//
//            val detalle = detailRepo.detail(
//            )
//        }
//    }

}



