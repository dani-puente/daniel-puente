package com.example.aplicacionciudades.model.bbdd

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [EntitiFavs::class],
    version = 1
)
abstract class FavsDb : RoomDatabase(){
    abstract fun LugarDao(): LugarDao
}