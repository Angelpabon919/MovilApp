package com.example.movilapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.movilapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }
        binding.btnIniciarSesion.setOnClickListener {
            val correo = binding.etCorreo.text.toString()
            val contraseña = binding.etContrasena.text.toString()

            if (correo.isEmpty() || contraseña.isEmpty()) {
                Toast.makeText(this, "Completa los Campos", Toast.LENGTH_SHORT).show()
            } else if (correo == "admin@gmail.com" && contraseña == "1234") {
                Toast.makeText(this, "Inicio Sesion Correctamente", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Correo o Contraseña Incorrecto", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

