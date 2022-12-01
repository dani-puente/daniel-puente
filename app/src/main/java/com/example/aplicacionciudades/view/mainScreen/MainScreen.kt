package com.example.aplicacionciudades.view.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.view.detailScreen.getDetailScreenRoute
import com.example.aplicacionciudades.view.mainScreen.cardsLugares.MakeItemPlaceList
import com.example.aplicacionciudades.view.mainScreen.drawer.MakeDrawerView
import com.example.aplicacionciudades.view.mainScreen.toolbar.MakeToolbarMain
import com.example.aplicacionciudades.viewmodel.MainScreenVM
import kotlinx.coroutines.launch

@Composable
fun MainScreen(navController: NavController, vm: MainScreenVM = hiltViewModel()) {


    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val icono = R.drawable.ic_favorito_lleno
    val fichasState = vm.fichas.collectAsState()
    val fichas by remember {
        fichasState
    }
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