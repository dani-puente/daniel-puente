package com.example.aplicacionciudades.ui.view.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.ui.res.AplicacionCiudades
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    //Simulamos un delay de 2 segundos, el key indica un repintado automatico en JC, como solo queremos navegar despues del Splash
    //la indicamos a true, no sera una key que pueda mutar
    LaunchedEffect(key1 = true){
        delay(2000)
        //Limpiamos el Stack de navegacion para que al dar atras no vuelva a la SplashScreen
        navController.popBackStack()
        //Mandamos a la aplicacion a la mainScreen
        navController.navigate("main")
    }
    Splash()

}

//@Preview(showBackground = true)
@Composable
fun Splash() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.mipmap.iconoleon_foreground),
            contentDescription = "Bandera de León",
            modifier = Modifier.size(height = AplicacionCiudades.iconNormal, width = AplicacionCiudades.iconNormal)
        )
    }
}

