package com.example.aplicacionciudades.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacionciudades.model.consultaapimain.FichaX
import com.example.aplicacionciudades.model.consultaapimain.RetroRepoFicha
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenVM @Inject constructor(
    private val retroRepoFicha: RetroRepoFicha
) : ViewModel(), CoroutineScope {
    override val coroutineContext = viewModelScope.coroutineContext
    private val _fichas = MutableStateFlow<List<FichaX>>(emptyList())
    val fichas = _fichas.asStateFlow()

    init {
        //listarFichas()
        launch {
            _fichas.value = retroRepoFicha.getFichas()
        }
    }

//    private fun listarFichas() {
//        viewModelScope.launch {
//            val fichasService = fichasRepo.listFichas(
//                ResourcesObject.idCategoriaPadre,
//                ResourcesObject.idIdioma,
//                ResourcesObject.idProyecto
//            )
//            _fichas.value = fichasService.fichas
//        }
//    }

}



