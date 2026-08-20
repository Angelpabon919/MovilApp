package com.example.movilapp
data class Medicamento(
    val id : Int,
    val nombre: String,
    val dosis : String,
    val presentacion: String,
    val momentoDia: String,
    val hora : String,
    var confirmado: Boolean = false

)
