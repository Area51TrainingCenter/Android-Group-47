package com.area51.claserecycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.area51.claserecycler.database.MetodoDBImpl
import com.area51.claserecycler.entidades.Persona
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
    }

    override fun onResume() {
        super.onResume()

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val genero = spGenero.selectedItem.toString()

            val persona = Persona()
            persona.nombre = nombre
            persona.apellido = apellido
            persona.genero = genero
            val database = MetodoDBImpl()
            val respuesta = database.registrar(persona)
            if (respuesta != null) {
                Toast.makeText(
                    this, "Se registro",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this, "Ocurrio un error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
