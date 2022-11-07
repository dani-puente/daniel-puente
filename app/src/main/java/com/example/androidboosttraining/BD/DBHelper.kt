package com.example.androidboosttraining.BD

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBHelper(
    context: Context?
) : SQLiteOpenHelper(context,"favoritos.db", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE favorito(id INT PRIMARY KEY, " +
                "esFav BIT NOT NULL," +
                "nombre VARCHAR," +
                "urlImagen VARCHAR)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE favorito")
        onCreate(p0)
    }

}