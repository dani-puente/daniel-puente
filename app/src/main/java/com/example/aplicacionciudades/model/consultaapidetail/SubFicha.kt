package com.example.aplicacionciudades.model.consultaApiDetail

data class SubFicha(
    val descripcion: String,
    val descripcionCorta: String,
    val direccion: String,
    val email: String,
    val fechaFin: String,
    val fechaInicio: String,
    val horaFin: String,
    val horaInicio: String,
    val idDetalle: Int,
    val idFicha: Int,
    val idIdioma: Int,
    val idImagen: Int,
    val importancia: Int,
    val latitud: Float,
    val longitud: Float,
    val media: MediaX,
    val nombre: String,
    val promociones: List<String>,
    val rutas: List<String>,
    val subFichas: List<Any>,
    val telefono: Int,
    val urlImagen: String
)