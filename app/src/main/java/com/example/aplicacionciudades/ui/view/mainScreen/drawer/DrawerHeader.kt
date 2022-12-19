package com.example.aplicacionciudades.ui.view.mainScreen.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.ui.res.Dimens

@Composable
fun DrawerHeader(
) {
    Box() {
        Image(painter = painterResource(id = R.drawable.bandera_leon), contentDescription = null)
        Text(
            text = stringResource(R.string.menu),
            fontWeight = FontWeight.SemiBold,
            fontSize = Dimens.titulo,
            modifier = Modifier.padding(top = Dimens.topHeader, start = Dimens.startHeader)
            )
    }
}
