package pe.area51.clasekotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

//public class MaiActivity extends AppCompatActivity{}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        btnMostrar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val genero = spGenero.selectedItem.toString()

            if (nombre.isEmpty()) {
                etNombre.error = "El campo es requerido"
                return@setOnClickListener
            } else
                etNombre.error = null

            Toast.makeText(this,
                    "Nombre $nombre - Genero $genero",
                    Toast.LENGTH_SHORT).show()
        }
        btnOpciones.setOnClickListener {
            val intent = Intent(this, OpcionesActivity::class.java)
            startActivity(intent)
        }
    }

    fun nombre(valor: String): String {
        return ""
    }
}
