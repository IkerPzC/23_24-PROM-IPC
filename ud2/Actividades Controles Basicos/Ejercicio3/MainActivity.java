package com.example.ejercicio3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumeroDNI;
    EditText editTextLetraDNI;
    Button buttonValidarDNI;
    TextView textViewResultado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumeroDNI = findViewById(R.id.editTextNumeroDNI);
        editTextLetraDNI = findViewById(R.id.editTextLetraDNI);
        buttonValidarDNI = findViewById(R.id.buttonValidarDNI);
        textViewResultado = findViewById(R.id.textViewResultado);

        buttonValidarDNI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarDNI();
            }
        });
    }

    private void validarDNI() {
        String numeroDNI = editTextNumeroDNI.getText().toString();
        String letraDNI = editTextLetraDNI.getText().toString();

        if (numeroDNI.isEmpty() || letraDNI.isEmpty()) {
            textViewResultado.setText("Por favor, ingrese el número y la letra del DNI.");
            return;
        }

        int numero;
        try {
            numero = Integer.parseInt(numeroDNI);
        } catch (NumberFormatException e) {
            textViewResultado.setText("El número de DNI debe ser un número válido.");
            return;
        }

        char letraCalculada = calcularLetraDNI(numero);

        if (letraDNI.toUpperCase().charAt(0) == letraCalculada) {
            textViewResultado.setText("DNI válido.");
        } else {
            textViewResultado.setText("DNI no válido.");
        }
    }

    private char calcularLetraDNI(int numeroDNI) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = numeroDNI % 23;
        return letras.charAt(indice);
    }
}
