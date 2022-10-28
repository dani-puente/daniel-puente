package com.example.androidboosttraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.androidboosttraining.databinding.ActivityDetailBinding
import com.example.androidboosttraining.consulta_api.Ficha


class DetailActivity : AppCompatActivity() {
    companion object {
        const val FICHA = "DetailActivity:ficha"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ficha = intent.getParcelableExtra<Ficha>(FICHA)
        if (ficha != null) {
            title = ficha.nombre
            Glide.with(this).load(ficha.urlImagen).into(binding.imagen)
            binding.descripcionCorta.text = ficha.descripcionCorta
        }else{
            Log.d("DetailActivity", "Estoy dando error")
        }
    }
}