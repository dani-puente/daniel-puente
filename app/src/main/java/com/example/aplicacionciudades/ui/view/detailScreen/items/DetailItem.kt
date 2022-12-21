package com.example.aplicacionciudades.ui.view.detailScreen.items

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
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
                    .padding(
                        horizontal = Dimens.paddingBetweenScreen,
                        vertical = Dimens.paddingBetweenItems
                    )
                    .clip(MaterialTheme.shapes.large)
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
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.padding(
                        horizontal = Dimens.paddingBetweenScreen,
                        vertical = Dimens.paddingBetweenItems
                    )
//                    TextStyle(
//                        shadow = Shadow(
//                            color = Color.Black,
//                            offset = Offset(Dimens.offsetX, Dimens.offsetY),
//                            blurRadius = Dimens.blurRadius
//                        )
//                    )
                )
            }
        }
        item {
            descCorta?.let { textDesc ->
                Text(
                    text = textDesc,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = Dimens.paddingBetweenScreen,
                            vertical = Dimens.paddingBetweenItems
                        ),
                    style = MaterialTheme.typography.body1
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
                    modifier = Modifier.padding(
                        horizontal = Dimens.paddingBetweenScreen,
                        vertical = Dimens.paddingBetweenItems
                    ),
                    style = MaterialTheme.typography.h5
//                        shadow = Shadow(
//                            color = Color.Black,
//                            offset = Offset(Dimens.offsetX, Dimens.offsetY),
//                            blurRadius = Dimens.blurRadius
//                        )
//                    )
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
            .padding(
                horizontal = Dimens.paddingBetweenScreen,
                vertical = Dimens.paddingBetweenItems
            )
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