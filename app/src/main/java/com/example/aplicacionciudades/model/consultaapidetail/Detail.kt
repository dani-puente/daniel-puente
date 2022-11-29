package com.example.aplicacionciudades.model.consultaapidetail

data class Detail(
    val descripcion: String,
    val descripcionCorta: String,
    val direccion: String,
    val email: String,
    val fechaFin: Any,
    val fechaInicio: Any,
    val horaFin: Any,
    val horaInicio: Any,
    val idDetalle: Any,
    val idFicha: Int,
    val idIdioma: Int,
    val idImagen: Int,
    val importancia: Int,
    val latitud: Double,
    val longitud: Double,
    val media: Media,
    val nombre: String,
    val promociones: List<Any>,
    val rutas: List<Ruta>,
    val subFichas: List<SubFicha>,
    val telefono: String,
    val urlImagen: String
)