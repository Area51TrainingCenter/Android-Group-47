package com.area51.clasemvp.ui.registro.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.area51.clasemvp.R
import com.area51.clasemvp.net.entidad.Usuario
import com.area51.clasemvp.ui.registro.presenter.RegistroPresenter
import com.area51.clasemvp.ui.registro.views.RegistroView
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity(), RegistroView {
    override fun respuestaGuardarUsuario(status: Boolean, usuario: Usuario?) {
        if (status) {
            finish()
            Toast.makeText(this,"Se registro",
                    Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this,"Ocurrio un error",
                    Toast.LENGTH_SHORT).show()
        }
    }

    var presenter: RegistroPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        presenter = RegistroPresenter()
        presenter!!.agregarView(this)
    }

    override fun onResume() {
        super.onResume()

        btnRegistrar.setOnClickListener {
            val usuario = etUsuario.text.toString()
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val contrasena = etContrasena.text.toString()
            val repContrasena = etRepContrasena.text.toString()

            presenter!!.registrarUsuario(usuario, nombre,
                    apellido, contrasena, repContrasena)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (presenter != null)
            presenter!!.eliminarView()
    }
}
