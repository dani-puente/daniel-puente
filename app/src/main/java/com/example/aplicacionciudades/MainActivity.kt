package com.example.aplicacionciudades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aplicacionciudades.ui.theme.AplicacionCiudadesTheme
import com.example.aplicacionciudades.view.SplashScreen
import com.example.aplicacionciudades.view.detailScreen.DetailScreen
import com.example.aplicacionciudades.view.mainScreen.MainScreen
import com.example.aplicacionciudades.viewmodel.MainActivityVM

class MainActivity : ComponentActivity() {

    private var mainActivityViewModel: MainActivityVM = MainActivityVM()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplicacionCiudadesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") {
                            SplashScreen(navController)
                        }
                        composable("main") {
                            val fichasState = mainActivityViewModel.fichas.collectAsState()
                            val listaFichas by remember {
                                fichasState
                            }
                            MainScreen(listaFichas, navController)
                        }
                        composable(
                            "detail/{idFicha}/{nombre}",
                            arguments = listOf(
                                navArgument(name = "idFicha") {
                                    type = NavType.IntType
                                },
                                navArgument(name = "nombre") {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            DetailScreen(
                                navController = navController, vm = viewModel()
                            )
                        }
                    }
                }
            }
        }
    }
}