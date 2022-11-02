package com.example.androidboosttraining.consulta_api_detalle

data class SubFicha(
    val descripcion: String,
    val descripcionCorta: String?,
    val direccion: Any,
    val email: Any,
    val fechaFin: Any,
    val fechaInicio: Any,
    val horaFin: Any,
    val horaInicio: Any,
    val idDetalle: Int,
    val idFicha: Int,
    val idIdioma: Int,
    val idImagen: Int,
    val importancia: Int,
    val latitud: Any,
    val longitud: Any,
    val media: Media,
    val nombre: String,
    val promociones: List<Any>,
    val rutas: List<Any>,
    val subFichas: List<Any>,
    val telefono: Any,
    val urlImagen: String
)