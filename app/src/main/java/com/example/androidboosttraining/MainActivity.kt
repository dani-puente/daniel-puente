package com.example.androidboosttraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.androidboosttraining.databinding.ActivityMainBinding
import com.example.androidboosttraining.consulta_api.Ficha
import com.example.androidboosttraining.consulta_api.FichaDBClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fichasAdapter = FichasAdapter(
            emptyList()
        ) {
            navigateTo(it)
        }

        binding.recycler.adapter = fichasAdapter

        lifecycleScope.launch {
            val idCategoriaPadre = getString(R.string.idCategoriaPadre)
            val idIdioma = getString(R.string.idIdioma)
            val idProyecto = getString(R.string.idProyecto)
            val listarFichas = FichaDBClient.service.listFichas(
                idCategoriaPadre.toInt(),
                idIdioma.toInt(),
                idProyecto.toInt()
            )
            fichasAdapter.ficha = listarFichas.fichas
            fichasAdapter.notifyDataSetChanged()

        }
    }

    private fun navigateTo(ficha: Ficha) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.FICHA, ficha)
        startActivity(intent)
    }
}