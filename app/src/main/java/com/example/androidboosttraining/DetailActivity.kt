package com.example.androidboosttraining

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.androidboosttraining.BD.DBHelper
import com.example.androidboosttraining.databinding.ActivityDetailBinding
import com.example.androidboosttraining.consulta_api_detalle.DetalleDBClient

import kotlinx.coroutines.launch


class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        val extras = intent.extras
        val idFicha = extras?.getInt("idFicha")
        val urlImagen = extras?.getString("urlImagen") ?: println(Log.e("Error", "Valor nulo"))
        val nombre = extras?.getString("nombre")?: println(Log.e("Error", "Valor nulo"))
        val dbHelper = DBHelper(this)
        val db = dbHelper.writableDatabase
        val estaEnFavoritos =
            db.rawQuery("SELECT id, esFav FROM favorito where id = '$idFicha'", null)
        if (estaEnFavoritos.moveToFirst()) {
            if (estaEnFavoritos.getInt(1) == 0) {
                binding.fab.setImageResource(R.drawable.ic_fav_vacio)
                setContentView(binding.root)
            } else {
                binding.fab.setImageResource(R.drawable.ic_fav_lleno)
                setContentView(binding.root)
            }
        } else {
            binding.fab.setImageResource(R.drawable.ic_fav_vacio)
            setContentView(binding.root)
        }
        val galeriaAdapter = GaleriaAdapter(
            emptyList()
        )


        // A la hora de crear el recyclerView, es conveniente indicar el layaout y el adapter
        val manager = GridLayoutManager(this, 1)
        binding.recyclerGaleria.layoutManager = manager
        binding.recyclerGaleria.adapter = galeriaAdapter

        val tituloActBar = extras?.getString("tituloActBar")
        binding.fab.setOnClickListener {
            val db = dbHelper.writableDatabase
            val consulta = db.rawQuery("SELECT id, esFav FROM favorito where id = '$idFicha'", null)
            if (consulta.moveToFirst()) {
                if (consulta.getInt(1) == 0) {
                    binding.fab.setImageResource(R.drawable.ic_fav_lleno)
                    val registro = ContentValues()
                    registro.put("esFav", 1)
                    db.update("favorito", registro, "id = $idFicha", null)
                } else {
                    binding.fab.setImageResource(R.drawable.ic_fav_vacio)
                    val registro = ContentValues()
                    registro.put("esFav", 0)
                    db.update("favorito", registro, "id = $idFicha", null)
                }
            } else {
                binding.fab.setImageResource(R.drawable.ic_fav_lleno)
                val registro = ContentValues()
                registro.put("id", "$idFicha")
                registro.put("esFav", 1)
                registro.put("urlImagen", "$urlImagen")
                registro.put("nombre", "$nombre")
                db.insert("favorito", null, registro)
            }
            db.close()
        }
        if (tituloActBar != null) {
            title = tituloActBar
        } else {
            title = "null"
        }
        if (idFicha != null) {
            lifecycleScope.launch {
                val tipoFicha = getString(R.string.tipoFicha)
                val idIdioma = getString(R.string.idIdioma)
                val idProyecto = getString(R.string.idProyecto)
                val mostrarDetalle = DetalleDBClient.service.mostrarDetalle(
                    idFicha, tipoFicha, idIdioma.toInt(), idProyecto.toInt()
                )
                binding.descripcionCorta.text = mostrarDetalle.descripcionCorta
                binding.descripcion.text = mostrarDetalle.descripcion
                Glide.with(binding.root.context)
                    .load(mostrarDetalle.urlImagen)
                    .into(binding.imagen)

                galeriaAdapter.imagenes = mostrarDetalle.media.images
                galeriaAdapter.notifyDataSetChanged()
            }

        } else {
            Log.d("DetailActivity", "Estoy dando error")
        }
    }


}

