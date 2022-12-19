package com.example.aplicacionciudades.ui.view.detailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aplicacionciudades.ui.res.Loading
import com.example.aplicacionciudades.ui.utils.state.State
import com.example.aplicacionciudades.ui.view.Error
import com.example.aplicacionciudades.ui.viewModel.DetailScreenVM


fun getDetailScreenRoute(idFicha: Int, nombre: String): String {

    return "detail/$idFicha" +
            "/$nombre"
}

@Composable
fun DetailScreen(
    navController: NavController,
    vm: DetailScreenVM = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val detailState = vm.detailState.collectAsState()
    val esFavState = vm.esFav.collectAsState()
    val state by remember { detailState }
    val esFav by rememberSaveable { esFavState }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MakeToolbarDetail(navController, vm.nombre)
        },
        floatingActionButton = {
            //Mostramos el FAB si se han cargado los datos
            if (state == State.Success) {
                FloatingActionButton(onClick = {
                    onClick(esFav, vm)
                }) {
                    Icon(
                        imageVector =
                        if (esFav) {
                            Icons.Default.Favorite
                        } else {
                            Icons.Default.FavoriteBorder
                        },
                        contentDescription = null
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        content = { padding ->
            when (state) {
                State.Idle -> Loading()
                State.Loading -> Loading()
                State.Success -> Succcess(padding, vm)
                State.Failure -> Error {
                    vm.onDetailError()
                }
            }
        },
    )
}

fun onClick(esFav: Boolean, vm: DetailScreenVM) {
    if (esFav) {
        vm.borrarFav()
    } else {
        vm.establecerFav()
    }
}

@Composable
fun Succcess(padding: PaddingValues, vm: DetailScreenVM) {
    val urlState = vm.urlImagen.collectAsState()
    val url by remember { urlState }
    val descripcionState = vm.descripcion.collectAsState()
    val descripcion by remember { descripcionState }
    val mediaState = vm.urlsGaleria.collectAsState()
    val media by remember { mediaState }
    Column(modifier = Modifier.padding(padding)) {
        DetailItem(
            url,
            descripcion,
            media
        )
    }
}


