package com.example.aplicacionciudades.view.detailScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailItem(urlImagen: String?, descCorta: String?, urlsImagen: List<String?>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            AsyncImage(
                model = urlImagen,
                contentDescription = "Imagen de detalle",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(270.dp)
            )
        }
        stickyHeader {
            Box(modifier = Modifier
                .fillMaxSize()
                // Con esto hacemos que el stickyHeader tenga fondo y no sea transparente
               // .background(Color.White)
            ) {
                Text(
                    text = "Descripción corta",
                    style = TextStyle(
                        fontSize = 25.sp,
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(5.0f, 5.0f),
                            blurRadius = 30f
                        )
                    )
                )
            }
        }
        item {
            descCorta?.let { textDesc ->
                Text(
                    text = textDesc,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Justify
                )
            }
        }
        stickyHeader {
            Box(modifier = Modifier
                .fillMaxSize()
                //.background(Color.White)
            ) {
                Text(
                    text = "Galeria",
                    style = TextStyle(
                        fontSize = 25.sp,
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(10.0f, 10.0f),
                            blurRadius = 10f
                        )
                    )
                )
            }

        }
        items(urlsImagen.size) {
            Imagen(urlImagen = urlsImagen[it])
        }
    }
}

@Composable
private fun Imagen(urlImagen: String?) {
    AsyncImage(
        model = urlImagen,
        contentDescription = "Imagen galeria",
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    )
}

