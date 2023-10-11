package com.example.ejercicio2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNumero1, editTextNumero2, editTextResultado;
    private Button buttonComprobar;

    private TextView textViewPreguntasCorrectas, textViewPreguntasIncorrectas;

    private int aciertos = 0;
    private int fallos = 0;

    int numero1, numero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNumero1 = findViewById(R.id.editTextNumero1);
        editTextNumero2 = findViewById(R.id.editTextNumero2);
        editTextResultado = findViewById(R.id.editTextResultado);
        buttonComprobar = findViewById(R.id.buttonComprobar);
        textViewPreguntasCorrectas = findViewById(R.id.textViewPreguntasCorrectas);
        textViewPreguntasIncorrectas = findViewById(R.id.textViewPreguntasIncorrectas);

        // Generar números aleatorios y llenar los campos
        numero1 = numeroAleatorio(); // Números entre 0 y 100
        numero2 = numeroAleatorio();
        editTextNumero1.setText(String.valueOf(numero1));
        editTextNumero2.setText(String.valueOf(numero2));

        buttonComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int resultadoEsperado = numero1 + numero2;
                int resultadoIngresado = Integer.parseInt(editTextResultado.getText().toString());

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("resultadoEsperado", resultadoEsperado);
                intent.putExtra("resultadoIngresado", resultadoIngresado);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                boolean esCorrecto = data.getBooleanExtra("esCorrecto", false);
                if(esCorrecto){
                    aciertos++;
                    textViewPreguntasCorrectas.setText("PREGUNTAS CORRECTAS: "+aciertos);
                }else{
                    fallos++;
                    textViewPreguntasIncorrectas.setText("INCORRECTAS: "+fallos);
                }
            }else{

            }
        }
        numero1 = numeroAleatorio(); // Números entre 0 y 100
        numero2 = numeroAleatorio();
        editTextNumero1.setText(String.valueOf(numero1));
        editTextNumero2.setText(String.valueOf(numero2));
        editTextResultado.setText("");
    }

    private int numeroAleatorio(){
        return (int) (Math.random() * 101);
    }
}

