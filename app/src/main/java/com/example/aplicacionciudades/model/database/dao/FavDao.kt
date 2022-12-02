package com.example.aplicacionciudades.model.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.aplicacionciudades.model.database.entities.FavEntity

@Dao
interface FavDao {

    @Query("SELECT * FROM favoritos")
    suspend fun getId():List<FavEntity>

    @Insert
    suspend fun insertarFav(idFicha: Int){

    }
}