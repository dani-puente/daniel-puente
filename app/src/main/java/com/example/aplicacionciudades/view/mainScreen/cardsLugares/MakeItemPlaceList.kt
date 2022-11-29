package com.example.aplicacionciudades.view.mainScreen.cardsLugares

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aplicacionciudades.model.consultaapimain.FichaX

@Composable
fun MakeItemPlaceList(listaLugares: List<FichaX>, onClick: (item: FichaX) -> Unit) {//En la lambda se pasa un objeto de tipo FichaX y te devuelve un objeto Unit
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        items(listaLugares.size) {
            val item = listaLugares[it]
            ItemPlace(item, modifier = Modifier.clickable { onClick(item) })
            Spacer(modifier = Modifier.height(25.dp))
        }
    }
}