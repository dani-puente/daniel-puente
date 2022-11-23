package com.example.aplicacionciudades.view.mainScreen

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
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.model.consultaApi.FichaX
import com.example.aplicacionciudades.view.mainScreen.cardsLugares.MakeItemPlaceList
import com.example.aplicacionciudades.view.mainScreen.drawer.MakeDrawerView
import com.example.aplicacionciudades.view.mainScreen.toolbar.MakeToolbar
import kotlinx.coroutines.launch

@Composable
fun MainScreen(fichas: List<FichaX>) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
    ) {
        val scaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val icono = R.drawable.ic_favorito_lleno

        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                MakeToolbar {
                    scope.launch { scaffoldState.drawerState.open() }
                }
            },
            drawerContent = {
                MakeDrawerView(icono = icono)
            },
            content = { padding ->
                Column(modifier = Modifier.padding(padding)) {
                    MakeItemPlaceList(listaLugares = fichas)
                }
            }
        )
    }
}