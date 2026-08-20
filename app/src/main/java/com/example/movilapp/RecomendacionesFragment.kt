package com.example.movilapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movilapp.databinding.FragmentrecomendacionesBinding

class RecomendacionesFragment : Fragment() {

    private var _binding: FragmentrecomendacionesBinding? = null
    private val binding get() = _binding!!

    private val listaRecomendaciones = ArrayList<Recomendacion>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentrecomendacionesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cargarDatosEjemplo()

        binding.rvRecomendaciones.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRecomendaciones.adapter = RecomendacionAdapter(listaRecomendaciones)
    }

    private fun cargarDatosEjemplo() {
        if (listaRecomendaciones.isEmpty()) {
            listaRecomendaciones.add(
                Recomendacion(
                    1,
                    "POSTURA Y MOVILIDAD",
                    "Cambio de postura cada 2 horas",
                    "Alternar entre posición lateral izquierda y derecha para prevenir úlceras por presión."
                )
            )
            listaRecomendaciones.add(
                Recomendacion(
                    2,
                    "ALIMENTACIÓN E HIDRATACIÓN",
                    "Ofrecer líquidos a sorbos pequeños",
                    "Mantener hidratación constante durante la mañana. Evitar dar líquidos grandes antes de dormir."
                )
            )
            listaRecomendaciones.add(
                Recomendacion(
                    3,
                    "SEGURIDAD Y PACIENCIA",
                    "Acompañamiento en desplazamientos",
                    "El paciente presenta episodios de desorientación ligera al levantarse. Usar siempre el caminador."
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}