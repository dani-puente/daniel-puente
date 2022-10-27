package com.example.androidboosttraining

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidboosttraining.databinding.ViewFichaItemBinding
import com.example.androidboosttraining.consulta_api.Ficha


class FichasAdapter(
    var ficha: List<Ficha>,
    private val movieClickedListener: (ficha: Ficha) -> Unit
) :
    RecyclerView.Adapter<FichasAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ViewFichaItemBinding) :
        RecyclerView.ViewHolder(binding.root) { //root es la raiz de las vistas infladas con binding
        fun bind(ficha: Ficha) {
            binding.titulo.text = ficha.nombre
            Glide
                .with(binding.root.context)
                .load(ficha.urlImagen)
                .into(binding.caratula)
        }
    }

    //Crea una nueva vista cuando el RecyclerView se lo pida
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ViewFichaItemBinding.inflate(
            LayoutInflater
                .from(parent.context),// parent es de tipo ViewGroup, extiende de View, por lo que pedimos el contexto de parent
            parent,//nos pide un ViewGroup, pasamos parent
            false//attachToParent, le decimos si una vez que se infle la vista como hijo de la vista padre,false porque el recyclerView se encarga
        )

        /*
        LayoutInflater
            .from(parent.context) //como no tenenemos un contexto, ponemos el parent.context, que representa al recycler view
            .inflate(
                R.layout.view_movie_item,//inflamos la vista que representa el layout adapter
                parent,//pasamos parent porque es el  viewGroup que se pasa por parametro
                false//attachRoot, le decimos si una vez que se infle la vista como hijo de la vista padre,false porque el recyclerView se encarga
            )
         */
        return ViewHolder(binding)
    }

    //Actualiza una vista cuando el Adapter se lo pida
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ficha = ficha[position]
        holder.bind(ficha)
        holder.itemView.setOnClickListener {
            movieClickedListener(ficha)
        }
    }

    //devuelve el numero de elementos que tiene el adapter
    override fun getItemCount(): Int {
        return ficha.size
    }
}