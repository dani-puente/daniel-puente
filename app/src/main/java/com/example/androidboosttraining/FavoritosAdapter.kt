package com.example.androidboosttraining

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidboosttraining.databinding.ViewFavoritosItemBinding

class FavoritosAdapter(
    var ficha: MutableList<FichaFav>,
    private val fichaClickedListener: (ficha: FichaFav) -> Unit
) :
    RecyclerView.Adapter<FavoritosAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ViewFavoritosItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ficha: FichaFav) {
            Glide
                .with(binding.root.context)
                .load(ficha.urlImagen)
                .into(binding.imagenFav)
            binding.tituloFav.text = ficha.nombre
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ViewFavoritosItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ficha = ficha[position]
        holder.bind(ficha)
        holder.itemView.setOnClickListener {
            fichaClickedListener(ficha)
        }
    }

    override fun getItemCount(): Int {
        return ficha.size
    }
}