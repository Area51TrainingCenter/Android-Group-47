package com.area51.claserecycler

import android.app.AlertDialog
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.area51.claserecycler.database.MetodoDBImpl
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
        fun init(persona: Persona, context: Context, lista: ArrayList<Persona>) {
            itemView.tvNombre.text = persona.nombre
            itemView.tvApellido.text = persona.apellido
            itemView.tvGenero.text = persona.genero

            itemView.contenedor.setOnClickListener {
                val dialog = AlertDialog.Builder(context)
                dialog.setTitle("Acción")
                dialog.setPositiveButton("Eliminar") { dialogInterface, i ->

                    val sql = MetodoDBImpl()
                    sql.eliminar(persona.id)
                    lista.remove(persona)

                }
                dialog.setNegativeButton("Actualizar") { dialogInterface, i ->

                }
                dialog.show()
            }
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        val holder = (p0 as PersonaViewHolder)
        holder.init(lista[p1], context, lista)
    }

}