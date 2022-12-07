package com.example.aplicacionciudades.model.database.dao

import androidx.room.*
import com.example.aplicacionciudades.model.database.entities.FavEntity

//Data Access Object
@Dao
interface FavDao {
    //Con : le estoy diciendo que recupere los valores pasados por parametro de la suspend fun
    @Query("SELECT * FROM favoritos WHERE idFicha = :idFicha")
    suspend fun estaEnFavoritos(idFicha: Int): List<FavEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarFav(fav: FavEntity)

    @Delete
    suspend fun borrarFav(fav: FavEntity)

    @Query("SELECT * FROM favoritos")
    suspend fun listarFavoritos(): List<FavEntity>
}