package com.example.aplicacionciudades.ui.res

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Dimens de la app para el flavor actual.
 */

interface IDimens {
    // MARGIN
    val heightHeader get() = 270.dp
    val heightEmptyGallery get() = 400.dp

    //CARDS
    val paddingCards get() = 10.dp
    val elevation get() = 10.dp
    val textTop get() = 5.dp
    val textBottom get() = 5.dp
    //DRAWERVIEW
    //HEADER
    //MARGINHEADER
    val topHeader get() = 170.dp
    val startHeader get() = 10.dp
    //DIVIDER
    val thickness get() = 3.dp
    //BODY
    val paddingItem get() = 16.dp

    // MODULE
    // ICON
    val iconNormal get() = 150.dp

    //TEXT
    val titulo get() = 34.sp
    val titulo2 get() = 24.sp
    val subtitulos get() = 16.sp
    val texto get() = 16.sp

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

object Dimens : IDimens