package com.example.aplicacionciudades.ui.view.mainScreen.drawer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.ui.res.Dimens

@Composable
fun DrawerHeader(
) {
    Box() {
        Text(
            text = stringResource(R.string.menu),
            fontWeight = FontWeight.Bold,
            fontSize = Dimens.titulos,
            modifier = Modifier.padding(top = 100.dp, start = 10.dp),
            )
    }
}
