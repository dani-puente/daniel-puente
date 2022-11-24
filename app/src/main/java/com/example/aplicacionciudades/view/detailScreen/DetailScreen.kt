package com.example.aplicacionciudades.view.detailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun DetailScreen(navController: NavController, idFicha: Int?, nombre: String?, urlImagen: String?) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                MakeToolbarDetail(navController, nombre)
            },
            content = {padding ->
                Column(modifier = Modifier.padding(padding)) {
                    DetailItem(idFicha, urlImagen)
                }
            }
        )
    }
}
