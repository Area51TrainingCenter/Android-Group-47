package com.area51.claseencuesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class VisualizarActivity extends AppCompatActivity {
    private LinearLayout contenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        contenedor = findViewById(R.id.contenedor);

        for (Pregunta item : MainActivity.lista) {

            LinearLayout.LayoutParams textParams =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
            textParams.setMargins(20, 20, 20, 20);

            TextView tvPregunta = new TextView(this);
            tvPregunta.setLayoutParams(textParams);
            tvPregunta.setText(item.getPregunta());
            contenedor.addView(tvPregunta);

            if (item.isResponderOpcion()) {
                LinearLayout.LayoutParams editParams =
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT);
                EditText etResponder = new EditText(this);
                etResponder.setLayoutParams(editParams);
                contenedor.addView(etResponder);
            } else {
                LinearLayout.LayoutParams groupParams =
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT);
                RadioGroup group = new RadioGroup(this);
                group.setLayoutParams(groupParams);
                group.setOrientation(LinearLayout.VERTICAL);

                String opciones = item.getOpciones();
                String[] listaOpcion = opciones.split(",");
                if (listaOpcion.length > 0) {
                    for (String opt : listaOpcion) {

                        RadioButton radioButton = new RadioButton(this);
                        radioButton.setText(opt);
                        group.addView(radioButton);

                    }
                }

                contenedor.addView(group);

            }

        }
    }
}
