package com.example.aplicacionciudades.mainScreen.drawer

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

@Composable
fun MakeDrawerView(icono: Int) {
    DrawerHeader()
    DrawerBody(
        items = listOf(
            MenuItem(
                "Favoritos",
                ImageVector.vectorResource(id = icono)
            )
        )
    )
}