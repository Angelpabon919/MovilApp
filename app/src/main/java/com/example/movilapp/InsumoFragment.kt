package com.example.movilapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movilapp.com.example.movilapp.Insumo
import com.example.movilapp.databinding.FragmentinsumosBinding

class InsumosFragment : Fragment() {

    private var _binding: FragmentinsumosBinding? = null
    private val binding get() = _binding!!

    private val listaInsumos = ArrayList<Insumo>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentinsumosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cargarDatosEjemplo()

        binding.rvInsumos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvInsumos.adapter = InsumoAdapter(requireContext(), listaInsumos)
    }

    private fun cargarDatosEjemplo() {
        if (listaInsumos.isEmpty()) {
            listaInsumos.add(Insumo(1, "Pañales Talla L", 8))
            listaInsumos.add(Insumo(2, "Guantes Quirúrgicos (Caja)", 1))
            listaInsumos.add(Insumo(3, "Crema Anti-Escaras", 2))
            listaInsumos.add(Insumo(4, "Pañitos Húmedos (Paquete)", 3))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}