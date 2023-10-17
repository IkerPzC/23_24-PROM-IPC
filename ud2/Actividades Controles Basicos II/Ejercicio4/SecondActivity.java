package com.example.ejercicio2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private String colorSeleccionado; // Variable de instancia para almacenar el color seleccionado

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView txtMensaje = findViewById(R.id.txtMensaje);
        Button btnVolver = findViewById(R.id.btnVolver);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            colorSeleccionado = extras.getString("color"); // Almacenar el color seleccionado
            txtMensaje.setText("HAS PULSADO EL BOTÓN " + colorSeleccionado.toUpperCase());
        }

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Enviar de vuelta el color seleccionado
                Intent intent = new Intent();
                intent.putExtra("color", colorSeleccionado);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

