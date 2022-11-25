package com.example.aplicacionciudades.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.aplicacionciudades.model.consultaapidetail.Detail
import com.example.aplicacionciudades.model.consultaapidetail.detailRepo
import com.example.aplicacionciudades.ui.utils.State
import kotlinx.coroutines.flow.MutableStateFlow

class DetailScreenVM(private val stateHandle: SavedStateHandle) : ViewModel() {
    private val repo = detailRepo
    private val idFicha = stateHandle.get<Int>("idFicha")
    val fichaDetailState: MutableState<State<Detail, Nothing>> = mutableStateOf(State.Idle)

    fun init() {
        getFichaDetail()
    }

    private fun getFichaDetail() {
        //TODO:obtener detalle ficha API

        //emitir estado loading
        fichaDetailState.value = State.Loading
        //evaluar response y emitir estado ok o fail
        fichaDetailState.value = State.Success()
    }
}