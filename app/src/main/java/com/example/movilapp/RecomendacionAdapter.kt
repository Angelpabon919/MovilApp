package com.example.movilapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movilapp.databinding.ItemrecomendacionBinding

class RecomendacionAdapter(
    private val listaRecomendaciones: ArrayList<Recomendacion>
) : RecyclerView.Adapter<RecomendacionAdapter.RecomendacionViewHolder>() {

    class RecomendacionViewHolder(val binding: ItemrecomendacionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecomendacionViewHolder {
        val binding = ItemrecomendacionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecomendacionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecomendacionViewHolder, position: Int) {
        val reco = listaRecomendaciones[position]
        holder.binding.tvCategoriaReco.text = reco.categoria
        holder.binding.tvTituloReco.text = reco.titulo
        holder.binding.tvDescripcionReco.text = reco.descripcion
    }

    override fun getItemCount(): Int = listaRecomendaciones.size
}