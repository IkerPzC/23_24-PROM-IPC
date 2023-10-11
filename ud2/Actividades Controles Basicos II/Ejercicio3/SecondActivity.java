package com.example.ejercicio2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewNombre, textViewApellido, textViewSexo, textViewAficiones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewNombre = findViewById(R.id.textViewNombre);
        textViewApellido = findViewById(R.id.textViewApellido);
        textViewSexo = findViewById(R.id.textViewSexo);
        textViewAficiones = findViewById(R.id.textViewAficiones);

        Intent intent = getIntent();
        if (intent != null) {
            String nombre = intent.getStringExtra("nombre");
            String apellido = intent.getStringExtra("apellido");
            String sexo = intent.getStringExtra("sexo");
            String aficiones = intent.getStringExtra("aficiones");

            textViewNombre.setText("Nombre: " + nombre);
            textViewApellido.setText("Apellidos: " + apellido);
            textViewSexo.setText("Sexo: " + sexo);
            textViewAficiones.setText("Aficiones: " + aficiones);
        }
    }
}

