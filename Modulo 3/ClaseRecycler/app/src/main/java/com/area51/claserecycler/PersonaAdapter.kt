package com.area51.claserecycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_persona.view.*

class PersonaAdapter(val context: Context,
                     val lista: ArrayList<Persona>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.item_persona, p0, false)
        return PersonaViewHolder(view)
    }

    class PersonaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun init(persona: Persona) {
            itemView.tvNombre.text = persona.nombre
            itemView.tvApellido.text = persona.apellido
            itemView.tvGenero.text = persona.genero
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val holder = (p0 as PersonaViewHolder)
        holder.init(lista[p1])
    }

}