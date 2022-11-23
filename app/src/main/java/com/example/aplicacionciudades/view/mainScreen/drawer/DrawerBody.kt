package com.example.aplicacionciudades.view.mainScreen.drawer

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerBody(
    items: List<MenuItem>
) {
    LazyColumn() {
        items(items) { item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable { Log.i("info", "Estas pulsando aqui") }
                .padding(16.dp)
            ) {
                Icon(imageVector = item.icon, contentDescription = null)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = item.title)
            }
        }
    }
}