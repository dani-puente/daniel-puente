package com.example.androidboosttraining

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.core.view.GravityCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidboosttraining.BD.DBHelper
import com.example.androidboosttraining.databinding.ActivityMainBinding
import com.example.androidboosttraining.consulta_api.Ficha
import com.example.androidboosttraining.consulta_api.FichaDBClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "León"
        setSupportActionBar(binding.toolbar)
        //configuracion ActionBar
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu)
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        //Creamos adaptador
        val fichasAdapter = FichasAdapter(
            emptyList()
        ) {
            navigateTo(it)
        }
        //Definimos el layout que inflara el manager y el adapter que utilizara
        val manager = GridLayoutManager(this, 1)
        binding.recycler.layoutManager = manager
        binding.recycler.adapter = fichasAdapter
        //Creamos la base de datos si no existe
        val dBHelper = DBHelper(this)
        val db: SQLiteDatabase = dBHelper.writableDatabase
        db.close()
        //Se establece el comportamiento del boton en este caso del NavigationView, que mandara a la pantalla de favoritos
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.fav -> {
                    val intent = Intent(this, Favoritos::class.java)
                    startActivity(intent)
                }
            }
            false
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                //binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun navigateTo(ficha: Ficha) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("idFicha", ficha.idFicha)
        intent.putExtra("urlImagen", ficha.urlImagen)
        intent.putExtra("nombre", ficha.nombre)
        intent.putExtra("tituloActBar", ficha.nombre)
        startActivity(intent)
    }


}