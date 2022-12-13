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

    private val _fichas = MutableStateFlow(emptyList<FichaX>())
    val fichas = _fichas.asStateFlow()

    init {
        getFavoritos(retroRepoFicha)
    }

    fun getFavoritos(retroRepoFicha: RetroRepoFicha) {
        launch {
            favDao.getFavoritos().collect { favoritosIds ->
                try {
                    val fichas = retroRepoFicha.getFichas()
                    _fichas.value = fichas.filter { favoritosIds.contains(it.idFicha) }
                } catch (error: Throwable) {
                    Log.e("favsScreen", "Entro en el error en el metodo", error)
                }
            }
        }
    }
}