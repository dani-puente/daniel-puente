package com.example.aplicacionciudades.model.database.dao

import androidx.room.*
import com.example.aplicacionciudades.domain.model.toDomain
import com.example.aplicacionciudades.model.database.entities.FavEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//Data Access Object
@Dao
abstract class FavDao {
    //Con : le estoy diciendo que recupere los valores pasados por parametro de la suspend fun
    @Query("SELECT EXISTS(SELECT * FROM favoritos WHERE idFicha = :idFicha)")
    abstract fun estaEnFavoritos(idFicha: Int): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertarFav(fav: FavEntity)

    @Delete
    abstract suspend fun borrarFav(fav: FavEntity)

    @Query("SELECT * FROM favoritos")
    protected abstract fun _getFavoritos(): Flow<List<FavEntity>>

    //Mapea de entidad al modelo de datos que va a utilizar el ViewModel para tratar los datos
    fun getFavoritos() = _getFavoritos().map { favs -> favs.map { it.toDomain() } }


}