package com.example.aplicacionciudades.model.consultaApi

data class FichaX(
    val descripcionCorta: String,
    val distanciaUsuarioMetros: Any,
    val fechaFin: String,
    val fechaInicio: String,
    val horaFin: Any,
    val horaInicio: Any,
    val idFicha: Int,
    val latitud: Double,
    val longitud: Double,
    val nombre: String,
    val tipoFicha: String,
    val urlImagen: String
)