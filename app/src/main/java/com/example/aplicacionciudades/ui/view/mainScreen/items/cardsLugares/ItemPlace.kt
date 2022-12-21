package com.example.aplicacionciudades.ui.view.mainScreen.items.cardsLugares

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.example.aplicacionciudades.model.consultaApiMain.FichaX
import com.example.aplicacionciudades.ui.res.Dimens

@Composable
fun ItemPlace(lugar: FichaX, modifier: Modifier = Modifier) {
    Card(
        shape = MaterialTheme.shapes.large,
        elevation = Dimens.elevation,
        modifier = modifier
            .fillMaxSize()
            .padding(Dimens.paddingCards)
        //backgroundColor = Color.hsl(346f, 0.39f, .94f)

    ) {
        Column {
            AsyncImage(
                model = lugar.urlImagen,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.imageHeight)
                    .clip(RoundedCornerShape(Dimens.clipShape)),
                contentDescription = null,
                contentScale = ContentScale.Crop,

                )
            Text(
                text = lugar.nombre,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = Dimens.textTop,
                        bottom = Dimens.textBottom,
                        start = Dimens.textStart
                    ),
                style = MaterialTheme.typography.h6
            )
            Text(
                text = lugar.descripcionCorta,
                modifier = Modifier.padding(
                    start = Dimens.textStart,
                    bottom = Dimens.textBottom,
                    end = Dimens.textEnd
                ),
                style = MaterialTheme.typography.body1
//                maxLines = 2,
//                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

