package com.example.ejercicio2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNombre, editTextApellido;
    private RadioGroup radioGroupSexo;
    private RadioButton radioButtonMasculino, radioButtonFemenino;
    private CheckBox checkBoxMusica, checkBoxLectura, checkBoxDeportes, checkBoxViajar;
    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        radioGroupSexo = findViewById(R.id.radioGroupSexo);
        radioButtonMasculino = findViewById(R.id.radioButtonMasculino);
        radioButtonFemenino = findViewById(R.id.radioButtonFemenino);
        checkBoxMusica = findViewById(R.id.checkBoxMusica);
        checkBoxLectura = findViewById(R.id.checkBoxLectura);
        checkBoxDeportes = findViewById(R.id.checkBoxDeportes);
        checkBoxViajar = findViewById(R.id.checkBoxViajar);
        buttonEnviar = findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validarDatos()) {
                    // Datos válidos, enviar a la segunda actividad
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("nombre", editTextNombre.getText().toString());
                    intent.putExtra("apellido", editTextApellido.getText().toString());

                    int selectedRadioButtonId = radioGroupSexo.getCheckedRadioButtonId();
                    if (selectedRadioButtonId == radioButtonMasculino.getId()) {
                        intent.putExtra("sexo", "Masculino");
                    } else if (selectedRadioButtonId == radioButtonFemenino.getId()) {
                        intent.putExtra("sexo", "Femenino");
                    }

                    String aficiones = "";
                    if (checkBoxMusica.isChecked()) {
                        aficiones += "Música, ";
                    }
                    if (checkBoxLectura.isChecked()) {
                        aficiones += "Lectura, ";
                    }
                    if (checkBoxDeportes.isChecked()) {
                        aficiones += "Deportes, ";
                    }
                    if (checkBoxViajar.isChecked()) {
                        aficiones += "Viajar, ";
                    }
                    if (aficiones.endsWith(", ")) {
                        aficiones = aficiones.substring(0, aficiones.length() - 2); // Eliminar la última coma y espacio
                    }
                    intent.putExtra("aficiones", aficiones);

                    startActivity(intent);
                }
            }
        });
    }

    private boolean validarDatos() {
        // Validar que se haya ingresado un nombre y un apellido
        if (editTextNombre.getText().toString().isEmpty() || editTextApellido.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa tu nombre y apellido.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // Validar que se haya seleccionado al menos un género
        if (radioGroupSexo.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Por favor, selecciona un género.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}

