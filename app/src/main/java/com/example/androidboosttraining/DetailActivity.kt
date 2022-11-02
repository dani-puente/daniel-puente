package com.example.androidboosttraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.androidboosttraining.databinding.ActivityDetailBinding
import com.example.androidboosttraining.consulta_api_detalle.DetalleDBClient
import kotlinx.coroutines.launch


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val galeriaAdapter = GaleriaAdapter(
            emptyList()
        )
        // A la hora de crear el recyclerView, es conveniente indicar el layaout y el adapter
        val manager = GridLayoutManager(this, 1)
        binding.recyclerGaleria.layoutManager = manager
        binding.recyclerGaleria.adapter = galeriaAdapter

        val extras = intent.extras
        val idFicha = extras?.getInt("idFicha") ?: null
        val tituloActBar = extras?.getString("tituloActBar") ?: null
        var guardado = false
        binding.fab.setOnClickListener {
            if (guardado == true) {
                binding.fab.setImageResource(R.drawable.ic_fav_vacio)
                guardado = false
            } else {
                binding.fab.setImageResource(R.drawable.ic_fav_lleno)
                guardado = true
            }
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

