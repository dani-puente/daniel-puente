package com.example.androidboosttraining

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidboosttraining.consulta_api.Ficha
import com.example.androidboosttraining.databinding.FavoritosBinding

class Favoritos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = FavoritosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Favoritos"
        val favoritosAdapter = FavoritosAdapter(
            emptyList()
        ) {
            navigateTo(it)
        }
        //Definimos el manager del layout y definimos el adapter que utilizara
        val manager = GridLayoutManager(this, 1)
        binding.recycler.layoutManager = manager
        binding.recycler.adapter = favoritosAdapter
    }

    private fun navigateTo(ficha: Ficha) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("idFicha", ficha.idFicha)
        intent.putExtra("tituloActBar", ficha.nombre)
        startActivity(intent)
    }
}