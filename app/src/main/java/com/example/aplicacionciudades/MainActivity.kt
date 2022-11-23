package com.example.aplicacionciudades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aplicacionciudades.ui.theme.AplicacionCiudadesTheme
import com.example.aplicacionciudades.view.SplashScreen
import com.example.aplicacionciudades.view.mainScreen.MainScreen
import com.example.aplicacionciudades.viewmodel.MAViewModel

class MainActivity : ComponentActivity() {

    private var viewModel: MAViewModel = MAViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplicacionCiudadesTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "splash") {
                    composable("splash") {
                        SplashScreen(navController)
                    }
                    composable("main") {
                        val fichasState = viewModel.fichas.collectAsState()
                        val listaFichas by remember {
                            fichasState
                        }
                        MainScreen(listaFichas)
                    }
                    composable("detail"){

                    }
                }
            }
        }
    }
}
