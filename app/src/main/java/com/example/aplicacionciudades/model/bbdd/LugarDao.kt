package com.example.aplicacionciudades.model.bbdd

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LugarDao {
    @Query("SELECT * FROM EntityFavs")
    fun getIdLugar(): List<Int>

    @Insert
    fun insertFav(idFicha: Int)
}