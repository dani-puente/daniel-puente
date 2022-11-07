package com.example.androidboosttraining

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.androidboosttraining.BD.DBHelper
import com.example.androidboosttraining.databinding.FavoritosBinding

class Favoritos : AppCompatActivity() {
    val listaFavs: MutableList<FichaFav> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = FavoritosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Favoritos"
        consultaFavs()
        val favoritosAdapter = FavoritosAdapter(
            listaFavs
        ) {
            navigateTo(it)
        }
        //Definimos el manager del layout y definimos el adapter que utilizara
        val manager = GridLayoutManager(this, 1)
        binding.recycler.layoutManager = manager
        binding.recycler.adapter = favoritosAdapter
    }

    private fun consultaFavs() {
        val dBHelper = DBHelper(this)
        val db = dBHelper.writableDatabase.rawQuery(
            "SELECT urlImagen, nombre, id FROM favorito WHERE esFav = 1;",
            null
        )
        while (db.moveToNext()) {
            val ficha = FichaFav(db.getString(0), db.getString(1),db.getInt(2))
            println(ficha.urlImagen)
            println(ficha.nombre)
            println(ficha.idFicha)
            listaFavs.add(ficha)
        }
        db.close()
    }

    private fun navigateTo(ficha: FichaFav) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("idFicha", ficha.idFicha)
        intent.putExtra("tituloActBar", ficha.nombre)
        startActivity(intent)
    }
}