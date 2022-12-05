package com.example.aplicacionciudades.domain.model

import com.example.aplicacionciudades.model.database.entities.FavEntity

data class Favs(val idFicha: Int)

fun FavEntity.toDomain() = Favs(idFicha)