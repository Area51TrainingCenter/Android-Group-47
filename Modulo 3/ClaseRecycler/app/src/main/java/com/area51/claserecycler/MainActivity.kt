package com.area51.claserecycler

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var lista: ArrayList<Persona>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lista = arrayListOf()
        lista!!.add(Persona("Johann", "Jara", "Masculino"))
    }

    override fun onStart() {
        super.onStart()

        val adapter = PersonaAdapter(this, lista!!)
        rvDatos.layoutManager = LinearLayoutManager(this)
        rvDatos.adapter = adapter
    }
}
