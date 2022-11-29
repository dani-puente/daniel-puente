package com.example.aplicacionciudades.view.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.model.consultaapimain.FichaX
import com.example.aplicacionciudades.view.detailScreen.getDetailScreenRoute
import com.example.aplicacionciudades.view.mainScreen.cardsLugares.MakeItemPlaceList
import com.example.aplicacionciudades.view.mainScreen.drawer.MakeDrawerView
import com.example.aplicacionciudades.view.mainScreen.toolbar.MakeToolbarMain
import kotlinx.coroutines.launch

@Composable
fun MainScreen(fichas: List<FichaX>, navController: NavController) {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val icono = R.drawable.ic_favorito_lleno

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MakeToolbarMain {
                scope.launch { scaffoldState.drawerState.open() }
            }
        },
        drawerContent = {
            MakeDrawerView(icono = icono)
        },
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                MakeItemPlaceList(listaLugares = fichas) {
                    navController.navigate(getDetailScreenRoute(it.idFicha, it.nombre))
                }
            }
        }
    )
}