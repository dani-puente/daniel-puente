package com.example.aplicacionciudades.di

interface INetworkModule{
    val urlBase get() = "https://tuciudaddecerca-api.proconsi.com"
    val idCategoriaPadre get() = 30
    val idIdioma get() = 0
    val idProyecto get() = 1
    val tipoFicha get() =  "F"
}
object Url: INetworkModule