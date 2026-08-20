package  com.example.movilapp
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.movilapp.databinding.DatosbasicosBinding

class DatosBasicosFragment : Fragment() {

    // 1. Configuración de View Binding para el Fragmento
    private var _binding: DatosbasicosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DatosbasicosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 2. Evento del botón llamar usando el Intent Implícito expuesto en clase
        binding.btnLlamarFamiliar.setOnClickListener {
            val numeroTelefono = binding.tvTelefonoFamiliar.text.toString().replace(" ", "")

            // Creación del Intent Implícito para abrir el marcador del teléfono
            val intentLlamar = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$numeroTelefono")
            }
            startActivity(intentLlamar)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}