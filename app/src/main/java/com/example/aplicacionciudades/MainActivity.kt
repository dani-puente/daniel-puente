package com.example.aplicacionciudades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.aplicacionciudades.mainScreen.MakeToolbar
import com.example.aplicacionciudades.mainScreen.cardsLugares.MakeItemPlaceList
import com.example.aplicacionciudades.mainScreen.drawer.MakeDrawerView
import com.example.aplicacionciudades.ui.theme.AplicacionCiudadesTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                        MakeItemPlaceList()
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
                MakeItemPlaceList()
            }
        }
    }
}
