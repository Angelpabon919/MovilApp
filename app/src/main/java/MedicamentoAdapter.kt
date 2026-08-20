package com.example.movilapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.movilapp.databinding.ItemMedicamentoBinding

class MedicamentoAdapter(
    private val context: Context,
    private val listaMedicamentos: ArrayList<Medicamento>
) : RecyclerView.Adapter<MedicamentoAdapter.MedicamentoViewHolder>() {

    inner class MedicamentoViewHolder(val binding: ItemMedicamentoBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicamentoViewHolder {
        val binding = ItemMedicamentoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MedicamentoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedicamentoViewHolder, position: Int) {
        val med = listaMedicamentos[position]

        holder.binding.tvMomentoDia.text = "${med.momentoDia} — ${med.hora}"
        holder.binding.tvNombreMedicamento.text = med.nombre
        holder.binding.tvDosisPresentacion.text = "${med.dosis} (${med.presentacion})"

        if (med.confirmado) {
            holder.binding.btnItemConfirmar.text = "✓ Suministrado"
            holder.binding.btnItemConfirmar.setBackgroundColor(Color.GRAY)
            holder.binding.btnItemConfirmar.isEnabled = false
        } else {
            holder.binding.btnItemConfirmar.text = "✓ Confirmar"
            holder.binding.btnItemConfirmar.isEnabled = true
        }

        holder.binding.btnItemConfirmar.setOnClickListener {
            mostrarDialogoConfirmacion(med, holder.adapterPosition)
        }
    }

    private fun mostrarDialogoConfirmacion(med: Medicamento, position: Int) {
        AlertDialog.Builder(context)
            .setTitle("Confirmar Medicamento")
            .setMessage("¿Confirmas que el paciente tomó ${med.nombre} (${med.dosis})?")
            .setPositiveButton("Sí, Suministrado") { _, _ ->
                med.confirmado = true
                notifyItemChanged(position)
                Toast.makeText(context, "Registro guardado correctamente", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    override fun getItemCount(): Int = listaMedicamentos.size
}
