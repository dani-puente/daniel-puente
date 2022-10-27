package com.example.androidboosttraining.consulta_api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Ficha(
    val descripcionCorta: String?,
    val distanciaUsuarioMetros: Int?,
    val fechaFin: String?,
    val fechaInicio: String?,
    val horaFin: Date?,
    val horaInicio: Date?,
    val idFicha: Int?,
    val latitud: Double?,
    val longitud: Double?,
    val nombre: String?,
    val tipoFicha: String?,
    val urlImagen: String?
): Parcelable