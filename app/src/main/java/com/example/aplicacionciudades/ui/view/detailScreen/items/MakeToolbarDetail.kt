package com.example.aplicacionciudades.ui.view.detailScreen.items

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MakeToolbarDetail(navConttroller: NavController, nombre: String?) {
    TopAppBar(
        title = { nombre?.let { Text(it) } },
        navigationIcon = {
            IconButton(onClick = { navConttroller.navigate("main") }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )
            }
        }
    )
}