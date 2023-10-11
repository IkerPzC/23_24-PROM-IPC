package com.example.ejercicio2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    //private static final int REQUEST_CODE_SECOND_ACTIVITY = 1;
    private EditText editTextNombre;
    private EditText editTextApellido;
    private Button btnVolver;
    private Button btnVerificarCondiciones;

    private TextView textViewCondiciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        btnVolver = findViewById(R.id.btnVolver);
        btnVerificarCondiciones = findViewById(R.id.btnVerificarCondiciones);
        textViewCondiciones = findViewById(R.id.textViewCondiciones);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnVerificarCondiciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = editTextNombre.getText().toString();
                String apellido = editTextApellido.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("apellido", apellido);
                startActivityForResult(intent,1234);
            }
        });
    }

    public void onTextChanged(String newText) {
        // Actualiza el texto en función de newText
        String textoCondiciones = "Aceptas condiciones: " + newText;
        textViewCondiciones.setText(textoCondiciones);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1234 && resultCode==RESULT_OK){
            String resultado = data.getStringExtra("resultado");
            textViewCondiciones.setText("Aceptas condiciones: "+resultado);
        }
    }
}