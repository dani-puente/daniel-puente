package com.example.aplicacionciudades.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aplicacionciudades.model.database.dao.FavDao
import com.example.aplicacionciudades.model.database.entities.FavEntity

@Database(
    entities = [FavEntity::class],
    version = 1
)
abstract class FavoritosDB : RoomDatabase() {
    abstract fun getFavDao() : FavDao
}