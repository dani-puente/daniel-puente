package com.example.aplicacionciudades.model.consultaapimain

import kotlinx.serialization.Serializable

@Serializable
data class Ficha(
    val categorias: List<Any>,
    val fichas: List<FichaX>,
    val urlIcono: Any
)