package com.example.aplicacionciudades.ui.view.screenFavs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.model.consultaapimain.FichaX
import com.example.aplicacionciudades.ui.view.detailScreen.MakeToolbarDetail
import com.example.aplicacionciudades.ui.view.detailScreen.getDetailScreenRoute
import com.example.aplicacionciudades.ui.view.mainScreen.cardsLugares.MakeItemPlaceList
import com.example.aplicacionciudades.ui.viewmodel.FavsScreenVM


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
            MakeToolbarDetail(navConttroller = navController, nombre = stringResource(R.string.favs))
        },
        content = { padding ->
            body(padding, fichas, navController)
        }
    )
}

@Composable
private fun body(
    padding: PaddingValues,
    fichas: List<FichaX>,
    navController: NavController
) {
    Column(modifier = Modifier.padding(padding)) {
        MakeItemPlaceList(listaLugares = fichas) {
            navController.navigate(getDetailScreenRoute(it.idFicha, it.nombre))
        }
    }
}