package com.example.aplicacionciudades.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacionciudades.model.consultaApiMain.FichaX
import com.example.aplicacionciudades.model.consultaApiMain.RetroRepoFicha
import com.example.aplicacionciudades.model.database.dao.FavDao
import com.example.aplicacionciudades.ui.utils.state.StateT
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavsScreenVM @Inject constructor(
    private val favDao: FavDao,
    private val retroRepoFicha: RetroRepoFicha
) : ViewModel(), CoroutineScope {
    override val coroutineContext = viewModelScope.coroutineContext

    private val _favoritesState = MutableStateFlow<StateT<List<FichaX>>>(StateT.Idle)
    val favoritesState = _favoritesState.asStateFlow()

    init {
        getFavoritos(retroRepoFicha)
    }

    fun getFavoritos(retroRepoFicha: RetroRepoFicha) {
        launch {
            _favoritesState.value = StateT.Loading
            favDao.getFavoritos().collect { favoritosIds ->
                try {
                    val fichas = retroRepoFicha.getFichas()
                    val response = fichas.filter { favoritosIds.contains(it.idFicha) }
                    _favoritesState.value = StateT.Success(response)
                } catch (error: Throwable) {
                    _favoritesState.value = StateT.Failure
                }
            }
        }
    }

    fun onFavsError() = getFavoritos(retroRepoFicha = retroRepoFicha)


}