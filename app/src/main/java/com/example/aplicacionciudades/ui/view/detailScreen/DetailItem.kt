package com.example.aplicacionciudades.ui.view.detailScreen

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.ui.res.Dimens

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailItem(urlImagen: String?, descCorta: String?, urlsImagen: List<String?>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            AsyncImage(
                model = urlImagen,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.heightHeader)
            )
        }
        stickyHeader {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                // Con esto hacemos que el stickyHeader tenga fondo y no sea transparente
                // .background(Color.White)
            ) {
                Text(
                    text = stringResource(R.string.descripcionCorta),
                    style = TextStyle(
                        fontSize = Dimens.titulo2,
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(Dimens.offsetX, Dimens.offsetY),
                            blurRadius = Dimens.blurRadius
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
                        .padding(Dimens.paddingBetweenItems),
                    fontSize = Dimens.texto,
                    textAlign = TextAlign.Justify
                )
            }
        }
        stickyHeader {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                //.background(Color.White)
            ) {
                Text(
                    text = stringResource(R.string.galeria),
                    style = TextStyle(
                        fontSize = Dimens.titulo2,
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(Dimens.offsetX, Dimens.offsetY),
                            blurRadius = Dimens.blurRadius
                        )
                    )
                )
            }

        }
        if (urlsImagen.isEmpty()) {
            item { GaleriaVacia() }
        } else {
            items(urlsImagen.size) {
                Imagen(urlImagen = urlsImagen[it])
            }
        }
    }
}

@Composable
private fun Imagen(urlImagen: String?) {
    AsyncImage(
        model = urlImagen,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.paddingBetweenItems)
    )
}

@Composable
private fun GaleriaVacia() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.heightEmptyGallery),
        contentAlignment = Alignment.Center
    ) {
        Text(text = stringResource(R.string.galeriaVacia))
    }
}

