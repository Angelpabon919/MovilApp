package com.example.movilapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movilapp.databinding.FragmentmedicamentosBinding

class MedicamentosFragment : Fragment() {

    private var _binding: FragmentmedicamentosBinding? = null
    private val binding get() = _binding!!

    private val listaMedicamentos = ArrayList<Medicamento>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentmedicamentosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cargarDatosEjemplo()

        binding.rvMedicamentos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMedicamentos.adapter = MedicamentoAdapter(requireContext(), listaMedicamentos)
    }

    private fun cargarDatosEjemplo() {
        if (listaMedicamentos.isEmpty()) {
            listaMedicamentos.add(Medicamento(1, "Enalapril 10mg", "1 Pastilla", "vía oral", "AYUNAS", "6:00 AM"))
            listaMedicamentos.add(Medicamento(2, "Acetaminofén 500mg", "1 Pastilla", "vía oral", "MEDIODÍA", "12:00 PM"))
            listaMedicamentos.add(Medicamento(3, "Omeprazol 20mg", "1 Cápsula", "vía oral", "24 HORAS", "10:00 AM"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}