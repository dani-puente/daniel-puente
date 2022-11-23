package com.example.aplicacionciudades.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.model.consultaApi.FichaX
import com.example.aplicacionciudades.model.consultaApi.RetrofitRepository
import com.example.aplicacionciudades.model.consultaApi.fichasRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MAViewModel : ViewModel() {
    private val _fichas = MutableStateFlow<List<FichaX>>(emptyList())
    val fichas: StateFlow<List<FichaX>> get() = _fichas

    init {
//        viewModelScope.launch {
//            emitirFichas().collect {
//                _fichas.value = it
//            }
//        }
        emitirFichas()
    }
    private fun emitirFichas() {
        viewModelScope.launch {
            val fichasService = fichasRepo.listFichas(
                R.integer.idCategoriaPadre,
                R.integer.idIdioma,
                R.integer.idProyecto
            )
            _fichas.value = fichasService.fichas
            println(fichasService.fichas)
        }


    }


}



