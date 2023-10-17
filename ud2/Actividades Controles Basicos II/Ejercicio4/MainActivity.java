package com.example.ejercicio2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int contadorVerde = 0;
    private int contadorRojo = 0;
    private int contadorAzul = 0;
    private int contadorAmarillo = 0;
    private int contadorTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnVerde = findViewById(R.id.btnVerde);
        Button btnRojo = findViewById(R.id.btnRojo);
        Button btnAzul = findViewById(R.id.btnAzul);
        Button btnAmarillo = findViewById(R.id.btnAmarillo);

        final TextView txtContadorVerde = findViewById(R.id.txtContadorVerde);
        final TextView txtContadorRojo = findViewById(R.id.txtContadorRojo);
        final TextView txtContadorAzul = findViewById(R.id.txtContadorAzul);
        final TextView txtContadorAmarillo = findViewById(R.id.txtContadorAmarillo);
        final TextView txtContadorTotal = findViewById(R.id.txtContadorTotal);

        btnVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorVerde++;
                contadorTotal++;
                txtContadorVerde.setText("SELECCIÓN VERDE: " + contadorVerde);
                txtContadorTotal.setText("SELECCIÓN TOTAL: " + contadorTotal);
                lanzarSegundaActividad("verde");
            }
        });

        btnRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorRojo++;
                contadorTotal++;
                txtContadorRojo.setText("SELECCIÓN ROJO: " + contadorRojo);
                txtContadorTotal.setText("SELECCIÓN TOTAL: " + contadorTotal);
                lanzarSegundaActividad("rojo");
            }
        });

        btnAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorAzul++;
                contadorTotal++;
                txtContadorAzul.setText("SELECCIÓN AZUL: " + contadorAzul);
                txtContadorTotal.setText("SELECCIÓN TOTAL: " + contadorTotal);
                lanzarSegundaActividad("azul");
            }
        });

        btnAmarillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorAmarillo++;
                contadorTotal++;
                txtContadorAmarillo.setText("SELECCIÓN AMARILLO: " + contadorAmarillo);
                txtContadorTotal.setText("SELECCIÓN TOTAL: " + contadorTotal);
                lanzarSegundaActividad("amarillo");
            }
        });
    }

    private void lanzarSegundaActividad(String color) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("color", color);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            String color = data.getStringExtra("color");
        }
    }
}

