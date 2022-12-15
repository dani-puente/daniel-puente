package com.example.aplicacionciudades.view.mainScreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.model.consultaapimain.FichaX
import com.example.aplicacionciudades.view.detailScreen.getDetailScreenRoute
import com.example.aplicacionciudades.view.mainScreen.cardsLugares.MakeItemPlaceList
import com.example.aplicacionciudades.view.mainScreen.drawer.MakeDrawerView
import com.example.aplicacionciudades.view.mainScreen.toolbar.MakeToolbarMain
import com.example.aplicacionciudades.view.res.Loading
import com.example.aplicacionciudades.viewmodel.MainScreenVM
import com.example.aplicacionciudades.viewmodel.MyState
import kotlinx.coroutines.launch

@Composable
fun MainScreen(navController: NavController, vm: MainScreenVM = hiltViewModel()) {
    //Con rememberScaffoldState, guarda el estado del Scaffold
    val scaffoldState = rememberScaffoldState()
    //Guarda el ambito de la corrrutina
    val scope = rememberCoroutineScope()
    val icono = R.drawable.ic_favorito_lleno
    val fichasState = vm.fichas.collectAsState()
    //Esta escuchando fichasState se repintara en caso de que fichas cambie
    val fichas by remember {
        fichasState
    }
    val detailState = vm.detailState.collectAsState()
    val state by remember {
        detailState
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            //Este metodo crea la toolbar
            MakeToolbarMain {
                //Lanza la accion de sacar el DrawerState, tiene que estar en una corrutina
                scope.launch { scaffoldState.drawerState.open() }
            }
        },
        //Aqui metemos el contenido del DrawerView
        drawerContent = {
            //Creamos el DrawerView
            MakeDrawerView(icono = icono, navController)
        },
        //Indicamos que contenido a va tener el Scaffold, es conveniente pasar el padding, por compatibilidad en distintos dispositivos
        content = { padding ->
            when (state) {
                MyState.Idle -> Loading()
                MyState.Loading -> Loading()
                MyState.Success -> Success(
                    navController = navController,
                    padding = padding,
                    fichas = fichas
                )
                MyState.Failure -> Error(
                    navController = navController
                )
            }
        }
    )
}

@Composable
fun Error(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(Icons.Filled.Warning, contentDescription = null)
        TextButton(
            onClick = { navController.navigate("main") }
        ) {
            Text(text = stringResource(R.string.boton))
        }

    }
}

@Composable
fun Success(navController: NavController, padding: PaddingValues, fichas: List<FichaX>) {
    Column(modifier = Modifier.padding(padding)) {
        //metodo que dibuja los lugares
        MakeItemPlaceList(listaLugares = fichas) {
            navController.navigate(getDetailScreenRoute(it.idFicha, it.nombre))
        }
    }
}