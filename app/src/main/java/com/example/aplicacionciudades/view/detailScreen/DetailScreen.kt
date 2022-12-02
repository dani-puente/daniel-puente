package com.example.aplicacionciudades.view.detailScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
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
    vm: DetailScreenVM = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val detailState = vm.detailState.collectAsState()
    val state by remember{
        detailState
    }
    var esFav by rememberSaveable {
        mutableStateOf(false)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MakeToolbarDetail(navController, vm.nombre)
        },
        content = { padding ->
            when (state) {
                MyState.Idle -> Loading()
                MyState.Loading -> Loading()
                MyState.Success -> Succcess(padding, vm)
                MyState.Failure -> Error(navController)
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { vm.establecerFav() }) {
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

@Composable
fun Error(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        AlertDialog(
            onDismissRequest = { navController.popBackStack() },
            confirmButton = {
                TextButton(onClick = { navController.popBackStack() }) {
                    Text(text = "Volver atrás")
                }
            },
            title = {
                Row {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Icono de advertencia"
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "Error",
                        color = Color.Black,
                        fontSize = 20.sp

                    )
                }
            },
            text = {
                Text(
                    text = "Se ha producido un error al cargar los datos, inténtelo de nuevo mas tarde",
                    textAlign = TextAlign.Center
                )
            }
        )
    }
}
