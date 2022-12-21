package com.example.aplicacionciudades.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.aplicacionciudades.model.consultaApiMain.FichaX
import com.example.aplicacionciudades.ui.view.detailScreen.getDetailScreenRoute
import com.example.aplicacionciudades.ui.view.mainScreen.items.cardsLugares.MakeItemPlaceList

@Composable
fun Success(navController: NavController, padding: PaddingValues, fichas: List<FichaX>) {
    Column(modifier = Modifier.padding(padding)) {
        MakeItemPlaceList(listaLugares = fichas) {
            navController.navigate(getDetailScreenRoute(it.idFicha, it.nombre))
        }
    }
}