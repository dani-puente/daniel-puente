package com.example.aplicacionciudades.model.bbdd

import android.app.Application
import androidx.room.Room

class FavsApp: Application() {
    val room = Room
        .databaseBuilder(this, FavsDb::class.java, "favs")
        .build()
}