package com.area51.claserecycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.area51.claserecycler.database.MetodoDBImpl
import com.area51.claserecycler.entidades.PersonaEntidad
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {
    var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        if (intent.hasExtra("item")) {
            val persona = intent.getParcelableExtra<Persona>("item")
            if (persona != null) {
                id = persona.id
                etNombre.setText(persona.nombre)
                etApellido.setText(persona.apellido)
                for ((count, i: String) in
                resources.getStringArray(R.array.genero).withIndex()) {
                    if (i == persona.genero) {
                        spGenero.setSelection(count)
                        return
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val genero = spGenero.selectedItem.toString()

            val persona = PersonaEntidad()
            persona.nombre = nombre
            persona.apellido = apellido
            persona.genero = genero
            if (id != null)
                persona.id = id!!
            val database = MetodoDBImpl()
            val respuesta = database.registrar(persona)
            if (respuesta != null) {

                etNombre.setText("")
                etApellido.setText("")
                spGenero.setSelection(0)

                finish()

                if (id != null) {
                    Toast.makeText(
                        this, "Se actualizo",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this, "Se registro",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    this, "Ocurrio un error",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
