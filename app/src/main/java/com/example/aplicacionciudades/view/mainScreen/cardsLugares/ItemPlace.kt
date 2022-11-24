package com.example.aplicacionciudades.view.mainScreen.cardsLugares

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.aplicacionciudades.model.consultaapimain.FichaX

@Composable
fun ItemPlace(lugar: FichaX, navController: NavController) {
    Card(
        modifier = Modifier
            .clickable{navController.navigate("detail")}
            .fillMaxSize()
            .padding(3.dp),
        elevation = 10.dp,

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
                modifier = Modifier.fillMaxSize().padding(top = 5.dp, bottom = 5.dp),
                textAlign = TextAlign.Center,
            )
        }
    }
}

