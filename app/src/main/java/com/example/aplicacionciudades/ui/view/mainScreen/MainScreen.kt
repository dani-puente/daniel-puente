package com.example.aplicacionciudades.ui.view.mainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.model.consultaapimain.FichaX
import com.example.aplicacionciudades.ui.res.Loading
import com.example.aplicacionciudades.ui.utils.state.StateT
import com.example.aplicacionciudades.ui.view.Error
import com.example.aplicacionciudades.ui.view.detailScreen.getDetailScreenRoute
import com.example.aplicacionciudades.ui.view.mainScreen.cardsLugares.MakeItemPlaceList
import com.example.aplicacionciudades.ui.view.mainScreen.drawer.MakeDrawerView
import com.example.aplicacionciudades.ui.view.mainScreen.toolbar.MakeToolbarMain
import com.example.aplicacionciudades.ui.viewmodel.MainScreenVM
import kotlinx.coroutines.launch

@Composable
fun MainScreen(navController: NavController, vm: MainScreenVM = hiltViewModel()) {
    //Con rememberScaffoldState, guarda el estado del Scaffold
    val scaffoldState = rememberScaffoldState()
    //Guarda el ambito de la corrrutina
    val scope = rememberCoroutineScope()
    val icono = R.drawable.ic_favorito_lleno
    val fichasState = vm.detailState.collectAsState()
    val state by remember {
        fichasState
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
            Body(navController = navController, vm = vm, padding = padding, state = state)

        }
    )
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

@Composable
fun Body(
    navController: NavController,
    vm: MainScreenVM,
    padding: PaddingValues,
    state: StateT<List<FichaX>>
) {
    when (state) {
        StateT.Idle -> Loading()
        StateT.Loading -> Loading()
        is StateT.Success-> Success(
            navController = navController,
            padding = padding,
            fichas = state.data
        )
        is StateT.Failure -> Error {
            vm.onFichasError()
        }
    }
}