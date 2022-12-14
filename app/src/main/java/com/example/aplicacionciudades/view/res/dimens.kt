package com.example.aplicacionciudades.view.res

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


/**
 * Dimens de la app para el flavor actual.
 */
val D = AplicacionCiudades

interface IDimens {
    // MARGIN
    val margin get() = 1.dp
    val doubleMargin get() = margin * 2
    // MODULE
    // ICON
    val iconNormal get() = 150.dp
    //TEXT
    val titulos get() = 40.sp
    //Spacer
    val horizontalSpace get() = 16.dp

}
object AplicacionCiudades : IDimens