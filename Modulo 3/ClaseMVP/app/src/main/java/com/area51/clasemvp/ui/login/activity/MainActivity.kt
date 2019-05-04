package com.area51.clasemvp.ui.login.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.area51.clasemvp.R
import com.area51.clasemvp.net.entidad.Usuario
import com.area51.clasemvp.ui.login.presenter.LoginPresenter
import com.area51.clasemvp.ui.login.views.LoginView
import com.area51.clasemvp.ui.registro.activity.RegistroActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginView {
    override fun respuestaValidarUsuario(status: Boolean, usuario: Usuario?) {
        if (status) {
            Toast.makeText(this,
                    "Usuario correcto", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this,
                    "Usuario incorrecto", Toast.LENGTH_SHORT).show()
        }
    }

    override fun irPantallaRegistro() {
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)
    }

    var presenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = LoginPresenter()
        presenter!!.agregarView(this)

        //presenter!!.cargarDatos()
    }

    override fun onDestroy() {
        super.onDestroy()

        if (presenter != null)
            presenter!!.eliminarView()
    }

    override fun onResume() {
        super.onResume()

        btnIngresar.setOnClickListener {
            val usuario = etUsuario.text.toString()
            val contrasena = etContrasena.text.toString()

            presenter!!.validarUsuario(usuario, contrasena)
        }
        tvRegistrar.setOnClickListener {
            presenter!!.irARegistro()
        }
    }
}
