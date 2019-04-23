package com.area51.claserecycler

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.area51.claserecycler.database.MetodoDBImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var lista: ArrayList<Persona>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lista = arrayListOf()
        //lista!!.add(PersonaEntidad("Johann", "Jara", "Masculino"))
    }

    override fun onStart() {
        super.onStart()

        if (lista != null)
            lista!!.clear()
        val database = MetodoDBImpl()
        val datos = database.listar()
        if (datos != null) {
            for (item: com.area51.claserecycler.entidades.PersonaEntidad in datos) {
                val persona = Persona(item.id, item.nombre!!, item.apellido!!, item.genero!!)
                lista!!.add(persona)
            }
        }

        val adapter = PersonaAdapter(this, lista!!)
        rvDatos.layoutManager = LinearLayoutManager(this)
        rvDatos.adapter = adapter
    }

    override fun onResume() {
        super.onResume()

        fabAgregar.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }
    }
}
