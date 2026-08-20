package com.example.movilapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.movilapp.com.example.movilapp.Insumo
import com.example.movilapp.databinding.IteminsumoBinding

class InsumoAdapter(
    private val context: Context,
    private val listaInsumos: ArrayList<Insumo>
) : RecyclerView.Adapter<InsumoAdapter.InsumoViewHolder>() {

    class InsumoViewHolder(val binding: IteminsumoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsumoViewHolder {
        val binding = IteminsumoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return InsumoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: InsumoViewHolder, position: Int) {
        val insumo = listaInsumos[position]
        val textoCantidad = "Disponible: " + insumo.cantidadDisponible + " unidades"

        holder.binding.tvNombreInsumo.text = insumo.nombre
        holder.binding.tvCantidadInsumo.text = textoCantidad

        holder.binding.btnSolicitarInsumo.setOnClickListener {
            mostrarDialogoPedido(insumo)
        }
    }

    private fun mostrarDialogoPedido(insumo: Insumo) {
        AlertDialog.Builder(context)
            .setTitle("Solicitar Insumo")
            .setMessage("¿Deseas enviar un reporte para solicitar reabastecimiento de " + insumo.nombre + "?")
            .setPositiveButton("Enviar Solicitud") { _, _ ->
                Toast.makeText(
                    context,
                    "Solicitud enviada al familiar a cargo",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    override fun getItemCount(): Int = listaInsumos.size
}