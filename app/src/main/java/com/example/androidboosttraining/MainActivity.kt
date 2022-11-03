package com.example.androidboosttraining

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidboosttraining.BD.DBHelper
import com.example.androidboosttraining.databinding.ActivityMainBinding
import com.example.androidboosttraining.consulta_api.Ficha
import com.example.androidboosttraining.consulta_api.FichaDBClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    companion object{

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "León"
        val fichasAdapter = FichasAdapter(
            emptyList()
        ) {
            navigateTo(it)
        }
        val manager = GridLayoutManager(this, 1)
        binding.recycler.layoutManager = manager
        binding.recycler.adapter = fichasAdapter
        var baseCreada = false
        if (baseCreada == false){
            val dBHelper = DBHelper(this)
            val db : SQLiteDatabase = dBHelper.writableDatabase
            db.close()
        }
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
        intent.putExtra("idFicha", ficha.idFicha)
        intent.putExtra("tituloActBar", ficha.nombre)
        startActivity(intent)
    }
}