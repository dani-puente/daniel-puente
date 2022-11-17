package com.example.aplicacionciudades.mainScreen.cardsLugares

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MakeItemPlaceList(){
    LazyColumn(
        modifier = Modifier.padding(10.dp),


    ){
        items(10){
            ItemPlace()
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}