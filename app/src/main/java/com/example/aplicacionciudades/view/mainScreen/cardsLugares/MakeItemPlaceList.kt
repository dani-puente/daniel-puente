package com.example.aplicacionciudades.view.mainScreen.cardsLugares

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aplicacionciudades.model.consultaapimain.FichaX

@Composable
fun MakeItemPlaceList(
    listaLugares: List<FichaX>,
    onClick: (item: FichaX) -> Unit
) {//En la lambda se pasa un objeto de tipo FichaX y te devuelve un objeto Unit
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        items(listaLugares.size) {
            if (listaLugares.isEmpty()) {
                EstaVacio()
            } else {
                val item = listaLugares[it]
                ItemPlace(item, modifier = Modifier.clickable { onClick(item) })
                Spacer(modifier = Modifier.height(25.dp))
            }
        }
    }
}

@Composable
fun EstaVacio() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "No hay nada por aqui :("
        )
    }
}