package com.example.aplicacionciudades.view.detailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.aplicacionciudades.viewmodel.DetailScreenVM


fun getDetailScreenRoute(idFicha: Int): String {

    return "detail/$idFicha"
}

@Composable
fun DetailScreen(
    navController: NavController,
    vm: DetailScreenVM
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                MakeToolbarDetail(navController, detail.nombre)
            },
            content = { padding ->
                Column(modifier = Modifier.padding(padding)) {
                    DetailItem(
                        detail.urlImagen,
                        detail.nombre,
                        detail.descripcionCorta,
                        detail.media
                    )
                }
            }
        )
    }
}
