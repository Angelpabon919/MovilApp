package com.example.movilapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.movilapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                24 + systemBars.left,
                24 + systemBars.top,
                24 + systemBars.right,
                24 + systemBars.bottom
            )

            insets
        }

        // BOTÓN REGISTRARSE
        binding.btnRegistrarse.setOnClickListener {

            val nombre = binding.etNombre.text.toString().trim()
            val documento = binding.etDocumento.text.toString().trim()
            val correo = binding.etCorreo.text.toString().trim()
            val telefono = binding.etTelefono.text.toString().trim()
            val password = binding.etPassword.text.toString()
            val confirmarContraseña = binding.etConfirmarContrasena.text.toString()

            if (nombre.isEmpty() ||
                documento.isEmpty() ||
                correo.isEmpty() ||
                telefono.isEmpty() ||
                password.isEmpty() ||
                confirmarContraseña.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Completa todos los campos",
                    Toast.LENGTH_SHORT
                ).show()

            } else if (password != confirmarContraseña) {

                Toast.makeText(
                    this,
                    "Las contraseñas no coinciden",
                    Toast.LENGTH_SHORT
                ).show()

            } else if (!binding.cbTerminos.isChecked) {

                Toast.makeText(
                    this,
                    "Debes aceptar los términos y condiciones",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                val preferencias = getSharedPreferences("usuario", Context.MODE_PRIVATE)

                preferencias.edit()
                    .putString("nombre", nombre)
                    .putString("documento", documento)
                    .putString("correo", correo)
                    .putString("telefono", telefono)
                    .putString("password", password)
                    .apply()

                Toast.makeText(
                    this,
                    "Registro exitoso",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        // ¿YA TIENES CUENTA? INGRESAR
        binding.tvingresar.setOnClickListener {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // FLECHA DE REGRESAR
        binding.btnVolver.setOnClickListener {

            finish()
        }
    }
}