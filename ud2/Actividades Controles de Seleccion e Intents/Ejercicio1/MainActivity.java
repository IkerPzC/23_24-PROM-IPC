package com.example.ejercicio2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerPaises;
    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerPaises = findViewById(R.id.spinnerPaises);
        textViewInfo = findViewById(R.id.textViewInfo);

        // Obtén los datos de los países (nombres, superficie, cantidad de habitantes)
        String[] paises = {"España", "Italia", "Andorra", "Japón"};
        double[] superficie = {506030, 302073, 468, 377973};
        int[] poblacion = {47000000, 59000000, 79000, 129000000};

        // Crea un ArrayAdapter para el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, paises);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPaises.setAdapter(adapter);

        // Establece un listener para el Spinner
        spinnerPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String paisSeleccionado = paises[position];
                double superficieSeleccionada = superficie[position];
                int poblacionSeleccionada = poblacion[position];

                // Muestra la información del país seleccionado en el TextView
                String info = "País: " + paisSeleccionado + "\nSuperficie: " + superficieSeleccionada + " km²\nHabitantes: " + poblacionSeleccionada;
                textViewInfo.setText(info);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // No se hace nada si no se selecciona ningún país
            }
        });
    }
}

