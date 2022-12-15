package com.example.aplicacionciudades.view.mainScreen.cardsLugares

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.aplicacionciudades.model.consultaapimain.FichaX
import com.example.aplicacionciudades.view.res.AplicacionCiudades

@Composable
fun ItemPlace(lugar: FichaX, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(AplicacionCiudades.paddingCards),
        elevation = AplicacionCiudades.elevation,

        ) {
        Column {
            AsyncImage(
                model = lugar.urlImagen,
                modifier = Modifier.fillMaxSize(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                text = lugar.nombre,
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = AplicacionCiudades.textTop, bottom = AplicacionCiudades.textBottom),
                textAlign = TextAlign.Center,
            )
        }
    }
}

