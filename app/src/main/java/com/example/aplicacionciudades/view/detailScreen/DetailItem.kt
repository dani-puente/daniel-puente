package com.example.aplicacionciudades.view.detailScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import com.example.aplicacionciudades.model.consultaapidetail.Media

@Composable
fun DetailItem(urlImagen: String?, nombre: String?, descCorta: String?, media: Media?) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            AsyncImage(
                model = urlImagen,
                contentDescription = "Imagen de detalle",
                modifier = Modifier
                    .fillMaxSize()
            )
            nombre?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .fillMaxSize(),
                    textAlign = TextAlign.Start
                )
                Text(text = "Descripción corta")
                descCorta?.let {textDesc ->
                    Text(
                        text = textDesc,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                Text(text = "Galeria")
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    media?.let{
                        items(media.images.size){ numImagen ->
                            AsyncImage(model = media.images[numImagen], contentDescription = "Imagen galeria")
                        }
                    }
                }
            }
        }
    }
}

