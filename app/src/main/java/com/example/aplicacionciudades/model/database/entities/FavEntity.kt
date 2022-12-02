package com.example.aplicacionciudades.model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "favoritos")
data class FavEntity(
    @ColumnInfo("idFicha") val idFicha: Int
)
