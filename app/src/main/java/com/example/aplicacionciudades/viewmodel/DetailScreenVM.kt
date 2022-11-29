package com.example.aplicacionciudades.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplicacionciudades.model.consultaapidetail.detailRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailScreenVM(
    /**
     * stateHandle trae los datos del intent del activity
     */
    private val stateHandle: SavedStateHandle
) : ViewModel(), CoroutineScope {
    override val coroutineContext = viewModelScope.coroutineContext
    private val repo = detailRepo
    private val idFicha = checkNotNull(stateHandle.get<Int>("idFicha"))
    val nombre = checkNotNull(stateHandle.get<String>("nombre"))

    private val _detailState = MutableStateFlow(MyState.Idle)
    val detailState = _detailState.asStateFlow()

    private val _urlImagen = MutableStateFlow<String?>(null)
    val urlImagen = _urlImagen.asStateFlow()

    private val _descripcion = MutableStateFlow<String?>(null)
    val descripcion = _descripcion.asStateFlow()

    private val _urlsGaleria = MutableStateFlow<List<String>>(emptyList())
    val urlsGaleria = _urlsGaleria.asStateFlow()

    init {
        getFichaDetail()
    }

    private fun getFichaDetail() {
        //emitir estado loading
        _detailState.value = MyState.Loading
        //obtener detalle ficha API
        //evaluar response y emitir estado ok o fail
        launch {
            try {
                val detail = repo.detail(
                    idFicha,
                    ResourcesObject.tipoFicha,
                    ResourcesObject.idIdioma,
                    ResourcesObject.idProyecto
                )
                _detailState.value = MyState.Success
                _urlImagen.value = detail.urlImagen
                _descripcion.value = detail.descripcion
                _urlsGaleria.value = detail.media.images
                // en caso de que salte algun error, lo tratas con trycatch y emites un estado de error
            } catch (ignore: Throwable) {
                _detailState.value = MyState.Failure
            }

        }
        //_detailState.value = State.Success()
    }

}