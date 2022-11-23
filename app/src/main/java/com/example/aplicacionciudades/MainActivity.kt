package com.example.aplicacionciudades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aplicacionciudades.ui.theme.AplicacionCiudadesTheme
import com.example.aplicacionciudades.view.SplashScreen
import com.example.aplicacionciudades.view.mainScreen.MainScreen
import com.example.aplicacionciudades.view.mainScreen.drawer.MakeDrawerView
import com.example.aplicacionciudades.view.mainScreen.toolbar.MakeToolbar
import com.example.aplicacionciudades.viewmodel.MAViewModel
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue

class MainActivity : ComponentActivity(){

    private var viewModel: MAViewModel = MAViewModel()
    //var fichas by remember { viewModel.fichas.collectAsState() }

    //: List<FichaX> = emptyList()
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
                }
            }
        }
    }
}


@Preview(

    showBackground = true, showSystemUi = true
)
@Composable
fun DefaultPreview() {
    AplicacionCiudadesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
        ) {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            val icono = R.drawable.ic_favorito_lleno
            Scaffold(
                scaffoldState = scaffoldState,
                topBar = {
                    MakeToolbar {
                        scope.launch { scaffoldState.drawerState.open() }
                    }
                },
                drawerContent = {
                    MakeDrawerView(icono = icono)
                }
            ) {
                // MakeItemPlaceList()
            }
        }
    }
}
