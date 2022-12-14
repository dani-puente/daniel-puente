package com.example.aplicacionciudades.view.mainScreen.cardsLugares

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aplicacionciudades.model.consultaapimain.FichaX

@Composable
fun MakeItemPlaceList(
    listaLugares: List<FichaX>,
    onClick: (item: FichaX) -> Unit
) {//En la lambda se pasa un objeto de tipo FichaX y te devuelve un objeto Unit
    //Misma funion que el Recycler, scroll en vertical
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        //Indicamos, el numero de items que vamos a poner en el LazyColumn, en nuestro caso va a depender de la lista que nos pase la API
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EstaVacio() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(Icons.TwoTone.Refresh, contentDescription = null )
        Text(
            text = "No hay nada por aqui"
        )
    }
}