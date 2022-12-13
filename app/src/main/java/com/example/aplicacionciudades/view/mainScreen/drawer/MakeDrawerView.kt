package com.example.aplicacionciudades.view.mainScreen.drawer

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController

@Composable
fun MakeDrawerView(icono: Int, navController: NavController) {
    DrawerHeader()
    DrawerBody(
        items = listOf(
            MenuItem(
                "Favoritos",
                ImageVector.vectorResource(id = icono)
            )
        )
    ){
        navController.navigate("favoritos")
    }
}