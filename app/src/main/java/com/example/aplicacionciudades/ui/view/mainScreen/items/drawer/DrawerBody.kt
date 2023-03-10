package com.example.aplicacionciudades.ui.view.mainScreen.items.drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.aplicacionciudades.ui.res.Dimens

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    onClick: () -> Unit
) {
    LazyColumn() {
        items(items) { item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .padding(Dimens.paddingItem)
            ) {
                Icon(imageVector = item.icon, contentDescription = null)
                Spacer(modifier = Modifier.width(Dimens.horizontalSpace))
                Text(text = item.title, fontSize = Dimens.subtitulos)
            }
        }
    }
}