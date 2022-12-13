package com.example.aplicacionciudades.view.screenFavs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aplicacionciudades.view.detailScreen.MakeToolbarDetail
import com.example.aplicacionciudades.view.detailScreen.getDetailScreenRoute
import com.example.aplicacionciudades.view.mainScreen.cardsLugares.MakeItemPlaceList
import com.example.aplicacionciudades.viewmodel.FavsScreenVM


@Composable
fun FavsScreen(navController: NavController, vm: FavsScreenVM = hiltViewModel()) {
    val scaffoldState = rememberScaffoldState()
    val fichasState = vm.fichas.collectAsState()
    val fichas by remember {
        fichasState
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MakeToolbarDetail(navConttroller = navController, nombre = "Favoritos")
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