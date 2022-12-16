package com.example.aplicacionciudades.ui.view.mainScreen.drawer

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.ui.res.AplicacionCiudades

@Composable
fun DrawerHeader(
) {
    Box() {
        Text(
            text = stringResource(R.string.menu),
            fontWeight = FontWeight.Bold,
            fontSize = AplicacionCiudades.titulos
            )
    }
}
