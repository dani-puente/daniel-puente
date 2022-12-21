package com.example.aplicacionciudades.di

import android.content.Context
import androidx.room.Room
import com.example.aplicacionciudades.model.database.FavoritosDB
import com.example.aplicacionciudades.model.database.dao.FavDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    //Nombre de la base de datos
    private const val DATABASE_NAME = "favoritos_db"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): FavoritosDB {
        return Room.databaseBuilder(context, FavoritosDB::class.java, DATABASE_NAME).build()
    }

    @Singleton
    @Provides
    fun provideFavDao(db: FavoritosDB): FavDao{
        return db.getFavDao()
    }

}