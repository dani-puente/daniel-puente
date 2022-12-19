package com.example.aplicacionciudades.ui.view.mainScreen.drawer

import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.ui.res.Dimens

@Composable
fun MakeDrawerView(icono: Int, navController: NavController) {
    //Con este metodo creamos la cabecera del DrawerView
    DrawerHeader()
    Divider(thickness = Dimens.thickness)
    //Creamos el cuerpo del DrawerView
    DrawerBody(
        //indicamos con items = los items que va a tener el menu, MenuItem es una dataClass, modelo que seguirian todos los items si se
        //quisiese añadir mas elementos al menu
        items = listOf(
            MenuItem(
                stringResource(R.string.item_favoritos),
                ImageVector.vectorResource(id = icono)
            )
        )
    ){
        navController.navigate("favoritos")
    }
}