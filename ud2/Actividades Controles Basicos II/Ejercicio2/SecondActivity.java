package com.example.ejercicio2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView textViewResultado;
    private Button buttonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewResultado = findViewById(R.id.textViewResultado);
        buttonVolver = findViewById(R.id.buttonVolver);

        Intent intent = getIntent();
        int resultadoEsperado = intent.getIntExtra("resultadoEsperado", 0);
        int resultadoIngresado = intent.getIntExtra("resultadoIngresado", 0);

        String resultado = (resultadoEsperado == resultadoIngresado) ? "CORRECTO" : "INCORRECTO";
        textViewResultado.setText("El resultado de la operación es " + resultado);

        buttonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("esCorrecto", resultadoEsperado == resultadoIngresado);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}

