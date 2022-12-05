package com.example.aplicacionciudades.model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Nombre de la tabla de la BBDD
@Entity(tableName = "favoritos")
data class FavEntity(
    //ColumnInfo es el nombre de la columna en la BBDD
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "idFicha") val idFicha: Int
)
