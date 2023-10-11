package com.example.ejercicio2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewResultado;
    private Button btnAceptar;
    private Button btnRechazar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewResultado = findViewById(R.id.textViewResultado);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnRechazar = findViewById(R.id.btnRechazar);

        Intent intent = getIntent();
        if (intent != null) {
            String nombre = intent.getStringExtra("nombre");
            String apellido = intent.getStringExtra("apellido");
            textViewResultado.setText("Hola, "+nombre + " " + apellido + " ¿Aceptas las condiciones?");

            btnAceptar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    intent.putExtra("resultado","ACEPTADO");
                    setResult(RESULT_OK,intent);
                    finish();
                }
            });

            btnRechazar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Enviar el resultado "RECHAZADO" a MainActivity
                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    intent.putExtra("resultado","RECHAZADO");
                    setResult(RESULT_OK,intent);
                    finish();
                }
            });
        }
    }
}