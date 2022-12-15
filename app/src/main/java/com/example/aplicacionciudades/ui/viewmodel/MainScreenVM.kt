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
    private val _detailState = MutableStateFlow(MyState.Idle)
    val detailState = _detailState.asStateFlow()

    private val _fichas = MutableStateFlow<List<FichaX>>(emptyList())
    val fichas = _fichas.asStateFlow()

    init {
        setMain()
    }

    private fun setMain() {
        launch {
            _detailState.value = MyState.Loading
            try {
                _fichas.value = retroRepoFicha.getFichas()
                _detailState.value = MyState.Success
            } catch (error: Throwable) {
                _detailState.value = MyState.Failure
            }
        }
    }
}



