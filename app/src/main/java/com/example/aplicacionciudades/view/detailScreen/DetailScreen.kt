package com.example.aplicacionciudades.view.detailScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.aplicacionciudades.viewmodel.DetailScreenVM
import com.example.aplicacionciudades.viewmodel.MyState


fun getDetailScreenRoute(idFicha: Int, nombre: String): String {

    return "detail/$idFicha" +
            "/$nombre"
}

@Composable
fun DetailScreen(
    navController: NavController,
    vm: DetailScreenVM
) {
    val scaffoldState = rememberScaffoldState()
    val detailState = vm.detailState.collectAsState()
    val state by remember {
        detailState
    }
    var esFav by remember {
        mutableStateOf(false)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MakeToolbarDetail(navController, vm.nombre)
        },
        content = { padding ->
            when (state) {
                MyState.Idle -> TODO()
                MyState.Loading -> Loading()
                MyState.Success -> Succcess(padding, vm)
                MyState.Failure -> TODO()
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {vm.establecerFav()}) {
                IconToggleButton(checked = esFav, onCheckedChange = {
                    esFav = it
                }) {
                    Icon(
                        imageVector =
                        if (!esFav) {
                            Icons.Default.FavoriteBorder
                        } else {
                            Icons.Default.Favorite
                        },
                        contentDescription = "Boton de favorito"
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End
    )
}

@Composable
fun Succcess(padding: PaddingValues, vm: DetailScreenVM) {
    val urlState = vm.urlImagen.collectAsState()
    val url by remember {
        urlState
    }
    val descripcionState = vm.descripcion.collectAsState()
    val descripcion by remember {
        descripcionState
    }
    val mediaState = vm.urlsGaleria.collectAsState()
    val media by remember {
        mediaState
    }
    Column(modifier = Modifier.padding(padding)) {
        DetailItem(
            url,
            descripcion,
            media
        )
    }
}

@Composable
fun Loading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
