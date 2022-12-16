package com.example.aplicacionciudades.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacionciudades.model.consultaapimain.FichaX
import com.example.aplicacionciudades.model.consultaapimain.RetroRepoFicha
import com.example.aplicacionciudades.ui.utils.state.StateT
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
    private val _detailState = MutableStateFlow< StateT<List<FichaX>>>(StateT.Idle)
    val detailState = _detailState.asStateFlow()

//    private val _fichas = MutableStateFlow<List<FichaX>>(emptyList())
//    val fichas = _fichas.asStateFlow()

    init {
        getFichas()
    }

    private fun getFichas() {
        launch {
            _detailState.value = StateT.Loading
            try {
                val response = retroRepoFicha.getFichas()
                _detailState.value = StateT.Success(response)
            } catch (error: Throwable) {
                _detailState.value = StateT.Failure
            }
        }
    }

    fun onFichasError() = getFichas()
}



