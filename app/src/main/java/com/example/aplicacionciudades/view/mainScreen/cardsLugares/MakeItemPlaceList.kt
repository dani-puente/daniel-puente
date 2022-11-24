package com.example.aplicacionciudades.view.mainScreen.cardsLugares

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aplicacionciudades.model.consultaapimain.FichaX

@Composable
fun MakeItemPlaceList(listaLugares: List<FichaX>, navController: NavController){
    LazyColumn(
        modifier = Modifier.padding(10.dp),


    ){
        items(listaLugares.size){
            ItemPlace(listaLugares[it],navController)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}