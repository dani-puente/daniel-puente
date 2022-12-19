package com.example.aplicacionciudades.ui.view.screenFavs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.model.consultaApiMain.FichaX
import com.example.aplicacionciudades.ui.res.Dimens
import com.example.aplicacionciudades.ui.res.Loading
import com.example.aplicacionciudades.ui.utils.state.StateT
import com.example.aplicacionciudades.ui.view.Error
import com.example.aplicacionciudades.ui.view.detailScreen.MakeToolbarDetail
import com.example.aplicacionciudades.ui.view.detailScreen.getDetailScreenRoute
import com.example.aplicacionciudades.ui.view.mainScreen.cardsLugares.ItemPlace
import com.example.aplicacionciudades.ui.viewModel.FavsScreenVM


@Composable
fun FavsScreen(navController: NavController, vm: FavsScreenVM = hiltViewModel()) {
    val scaffoldState = rememberScaffoldState()
    val favoritesState = vm.favoritesState.collectAsState()
    val state by remember { favoritesState }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MakeToolbarDetail(
                navConttroller = navController,
                nombre = stringResource(R.string.favs)
            )
        },
        content = { padding ->
            Body(navController = navController, vm, padding, state)
        }
    )
}

@Composable
private fun Body(
    navController: NavController,
    vm: FavsScreenVM,
    padding: PaddingValues,
    state: StateT<List<FichaX>>
) {
    when (state) {
        StateT.Idle -> Loading()
        StateT.Loading -> Loading()
        is StateT.Success -> SuccessFavs(navController = navController, padding = padding, fichas = state.data)
        is StateT.Failure -> Error { vm.onFavsError() }
    }
}
@Composable
fun SuccessFavs(navController: NavController, padding: PaddingValues, fichas: List<FichaX>) {
    Column(modifier = Modifier.padding(padding)) {
        MakeItemPlaceListFavs(listaLugares = fichas) {
            navController.navigate(getDetailScreenRoute(it.idFicha, it.nombre))
        }
    }
}

@Composable
fun MakeItemPlaceListFavs(listaLugares: List<FichaX>, onClick: (item: FichaX) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.paddingCards)
    ) {
        //Indicamos, el numero de items que vamos a poner en el LazyColumn, en nuestro caso va a depender de la lista que nos pase la API
        items(listaLugares.size) {
            if (listaLugares.isEmpty()) {
                com.example.aplicacionciudades.ui.view.screenFavs.EstaVacio()
            } else {
                val item = listaLugares[it]
                ItemPlace(item, modifier = Modifier.clickable { onClick(item) })
            }
        }
    }
}
@Composable
fun EstaVacio() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(Icons.Filled.Warning, contentDescription = null)
        Text(
            text = stringResource(R.string.cardsVacio)
        )
    }
}
