package com.example.aplicacionciudades.ui.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacionciudades.model.consultaApiDetail.RetroRepoDetail
import com.example.aplicacionciudades.model.database.dao.FavDao
import com.example.aplicacionciudades.model.database.entities.FavEntity
import com.example.aplicacionciudades.ui.utils.state.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenVM @Inject constructor(
    private val retroRepoDetail: RetroRepoDetail,
    private val favDao: FavDao,
    /**
     * stateHandle trae los datos del intent del activity
     */
    private val stateHandle: SavedStateHandle
) : ViewModel(), CoroutineScope {
    override val coroutineContext = viewModelScope.coroutineContext
    val idFicha = checkNotNull(stateHandle.get<Int>("idFicha"))
    val nombre = checkNotNull(stateHandle.get<String>("nombre"))

    private val _detailState = MutableStateFlow<State>(State.Idle)
    val detailState = _detailState.asStateFlow()

    private val _urlImagen = MutableStateFlow<String?>(null)
    val urlImagen = _urlImagen.asStateFlow()

    private val _descripcion = MutableStateFlow<String?>(null)
    val descripcion = _descripcion.asStateFlow()

    private val _urlsGaleria = MutableStateFlow<List<String>>(emptyList())
    val urlsGaleria = _urlsGaleria.asStateFlow()

    private val _esFav = MutableStateFlow(false)
    val esFav = _esFav.asStateFlow()


    init {
        getDetail()
        launch {
            favDao.estaEnFavoritos(idFicha).collect { _esFav.value = it }
        }
    }
    private fun getDetail() = launch {
        //emitir estado loading
        _detailState.value = State.Loading
        try {
            //obtener los detalles de la ficha y establecemos su valor en el observable
            //evaluar response y emitir estado ok o fail
            _urlImagen.value = retroRepoDetail.getDetail(idFicha).urlImagen
            _descripcion.value = retroRepoDetail.getDetail(idFicha).descripcion
            _urlsGaleria.value = retroRepoDetail.getDetail(idFicha).media.images
            _detailState.value = State.Success
            // en caso de que salte algun error, lo tratas con trycatch y emites un estado de error
        } catch (error: Throwable) {
            _detailState.value = State.Failure
        }
    }

    fun establecerFav() {
        launch {
            favDao.insertarFav(FavEntity(idFicha))
        }
    }

    fun borrarFav() {
        launch {
            favDao.borrarFav(FavEntity(idFicha))
        }
    }

    fun onDetailError() {
        getDetail()
    }

}