package com.example.aplicacionciudades.ui.view.mainScreen.toolbar

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.aplicacionciudades.R

@Composable
fun MakeToolbarMain(
    onNavigationIconClick: () -> Unit,
) {
    TopAppBar(
        title = { Text(stringResource(R.string.topAppBarName)) },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
        }
    )
}
