package com.example.aplicacionciudades.ui.view.mainScreen.items.cardsLugares

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.aplicacionciudades.R
import com.example.aplicacionciudades.model.consultaApiMain.FichaX
import com.example.aplicacionciudades.ui.res.Dimens

@Composable
fun MakeItemPlaceList(
    listaLugares: List<FichaX>,
    onClick: (item: FichaX) -> Unit
) {//En la lambda se pasa un objeto de tipo FichaX y te devuelve un objeto Unit
    //Misma funion que el Recycler, scroll en vertical
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.paddingCards),
        columns = GridCells.Adaptive(Dimens.gridAdaptive)
    ) {
        //Indicamos, el numero de items que vamos a poner en el LazyColumn, en nuestro caso va a depender de la lista que nos pase la API
        items(checkList(listaLugares)) {
            if (listaLugares.isEmpty()) {
                EstaVacio()
            } else {
                val item = listaLugares[it]
                ItemPlace(item, modifier = Modifier.clickable { onClick(item) })
            }
        }
    }
}

fun checkList(list: List<FichaX>): Int{
    val size: Int = if (list.isEmpty()){
        1
    } else{
        list.size
    }
    return size
}

//@Preview(showBackground = true, showSystemUi = true)
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