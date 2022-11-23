package com.example.aplicacionciudades.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacionciudades.model.consultaApi.FichaX
import com.example.aplicacionciudades.model.consultaApi.fichasRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MAViewModel : ViewModel() {
    private val _fichas = MutableStateFlow<List<FichaX>>(emptyList())
    val fichas: StateFlow<List<FichaX>> get() = _fichas

    init {
        listarFichas()
        Log.i("Info", "$_fichas")
    }

    private fun listarFichas() {
        viewModelScope.launch {
            val fichasService = fichasRepo.listFichas(
                Resources.idCategoriaPadre,
                Resources.idIdioma,
                Resources.idProyecto
            )
            _fichas.value = fichasService.fichas
        }
    }
}



