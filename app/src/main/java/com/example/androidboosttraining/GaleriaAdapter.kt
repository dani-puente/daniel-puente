package com.example.androidboosttraining

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidboosttraining.databinding.ViewGaleriaImagenesBinding

class GaleriaAdapter(
    var imagenes: List<String>
) : RecyclerView.Adapter<GaleriaAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ViewGaleriaImagenesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(imagen: String) {
            Glide.with(binding.root.context)
                .load(imagen)
                .into(binding.imagen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewGaleriaImagenesBinding
            .inflate(
                LayoutInflater.from(parent.context),parent, false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imagen = imagenes[position]
        holder.bind(imagen)
    }

    override fun getItemCount(): Int {
        return imagenes.size
    }
}