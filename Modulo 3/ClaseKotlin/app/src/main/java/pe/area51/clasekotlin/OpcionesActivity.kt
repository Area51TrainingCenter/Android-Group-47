package pe.area51.clasekotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_opciones.*

class OpcionesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)
    }

    override fun onResume() {
        super.onResume()

        btnIf.setOnClickListener {
            val valor1 = etValor1.text.toString()
            val valor2 = etValor2.text.toString()

            if (valor1 == valor2) {
                Toast.makeText(
                        this, "Los valores son iguales",
                        Toast.LENGTH_SHORT).show()
            }
        }
        btnFor.setOnClickListener {
            val generos = resources.getStringArray(R.array.genero)

            //for(String item:generos)

            for (item: String in generos) {
                Log.d("OpcionesActivity", "valor->$item")
            }
        }
        btnWhen.setOnClickListener {
            val valor1 = etValor1.text.toString()

            when (valor1) {
                "a" -> {
                    Log.d("OpcionesActivity", "valora $valor1")
                }
                "b" -> {
                    Log.d("OpcionesActivity", "valorb $valor1")
                }
                else -> {
                    Log.d("OpcionesActivity", "valorx $valor1")
                }
            }
        }
    }
}
