package com.example.aplicacionciudades.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aplicacionciudades.R

@Composable
fun SplashScreen() {
    Splash()
}

@Composable
fun Splash() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.mipmap.iconoleon_foreground),
            contentDescription = "Bandera de León",
            modifier = Modifier.size(150.dp, 150.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    SplashScreen()
}
