package com.example.aplicacionciudades.mainScreen.drawer

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun DrawerHeader(
) {
    Box() {
        Text(
            text = "Menú",
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp
            )
    }
}
