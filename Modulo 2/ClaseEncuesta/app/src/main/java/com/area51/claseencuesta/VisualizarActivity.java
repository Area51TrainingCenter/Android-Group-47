package com.area51.claseencuesta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class VisualizarActivity extends AppCompatActivity {
    private LinearLayout contenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        contenedor = findViewById(R.id.contenedor);

        for (Pregunta item : MainActivity.lista) {
            llamarPorCodigo(item);
            //llamarPorDiseno(item);
        }
    }

    private void llamarPorDiseno(Pregunta item) {
        View view = LayoutInflater.from(this)
                .inflate(R.layout.item_pregunta, null, false);

        TextView tvPregunta = view.findViewById(R.id.tvPregunta);
        RadioGroup rgPreguntas = view.findViewById(R.id.rgPreguntas);
        EditText etRespuesta = view.findViewById(R.id.etRespuesta);

        tvPregunta.setText(item.getPregunta());
        if (item.isResponderOpcion()) {
            rgPreguntas.setVisibility(View.GONE);
            etRespuesta.setVisibility(View.VISIBLE);
        } else {
            rgPreguntas.setVisibility(View.VISIBLE);
            etRespuesta.setVisibility(View.GONE);

            String opciones = item.getOpciones();
            String[] listaOpcion = opciones.split(",");
            if (listaOpcion.length > 0) {
                for (String opt : listaOpcion) {

                    RadioButton radioButton = new RadioButton(this);
                    radioButton.setText(opt);
                    rgPreguntas.addView(radioButton);

                }
            }
        }

        contenedor.addView(view);
    }

    private void llamarPorCodigo(Pregunta item) {
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

        LinearLayout.LayoutParams spinnerParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        Spinner spinner = new Spinner(this);
        spinner.setLayoutParams(spinnerParams);

        ArrayAdapter adapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.requerido)
        );
        spinner.setAdapter(adapter);
        contenedor.addView(spinner);
    }
}
