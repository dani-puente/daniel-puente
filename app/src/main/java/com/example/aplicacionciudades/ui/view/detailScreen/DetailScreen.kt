package com.example.aplicacionciudades.view.detailScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.view.res.Loading
import com.example.aplicacionciudades.viewmodel.DetailScreenVM
import com.example.aplicacionciudades.viewmodel.MyState


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
    val state by remember {
        detailState
    }
    val esFav by rememberSaveable {
        esFavState
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MakeToolbarDetail(navController, vm.nombre)
        },
        floatingActionButton = {
            //Mostramos el FAB si se han cargado los datos
            if (state == MyState.Success) {
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
                MyState.Idle -> Loading()
                MyState.Loading -> Loading()
                MyState.Success -> Succcess(padding, vm)
                MyState.Failure -> Error(
                    navController = navController,
                    vm = vm
                )
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
fun Error(navController: NavController, vm: DetailScreenVM) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(Icons.Filled.Warning, contentDescription = null)
        TextButton(
            onClick = { navController.navigate(getDetailScreenRoute(vm.idFicha, vm.nombre)) }
        ) {
            Text(text = stringResource(R.string.boton))
        }
    }
}


