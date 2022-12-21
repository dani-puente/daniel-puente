package com.example.aplicacionciudades.ui.view.favsScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.model.consultaApiMain.FichaX
import com.example.aplicacionciudades.ui.res.Loading
import com.example.aplicacionciudades.ui.utils.state.StateT
import com.example.aplicacionciudades.ui.view.Error
import com.example.aplicacionciudades.ui.view.Success
import com.example.aplicacionciudades.ui.view.detailScreen.items.MakeToolbarDetail
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
        is StateT.Success -> Success(navController = navController, padding = padding, fichas = state.data)
        is StateT.Failure -> Error { vm.onFavsError() }
    }
}

