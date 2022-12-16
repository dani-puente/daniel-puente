package com.example.aplicacionciudades.ui.res

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Dimens de la app para el flavor actual.
 */
val D = AplicacionCiudades

interface IDimens {
    // MARGIN
    val heightHeader get() = 270.dp
    val heightEmptyGallery get() = 400.dp

    //CARDS
    val paddingCards get() = 10.dp
    val elevation get() = 10.dp
    val textTop get() = 5.dp
    val textBottom get() = 5.dp

    // MODULE
    // ICON
    val iconNormal get() = 150.dp

    //TEXT
    val titulos get() = 40.sp
    val subtitulos get() = 25.sp
    val texto get() = 18.sp

    //SHADOW
    val offsetX get() = 5.0f
    val offsetY get() = 5.0f
    val blurRadius get() = 30f
    //Spacer
    val horizontalSpace get() = 16.dp
    //DETAIL
        //PADDING
        val paddingBetweenItems get() = 15.dp
}

object AplicacionCiudades : IDimens