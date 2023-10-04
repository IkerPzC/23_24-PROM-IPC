package com.example.ejercicio2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private Switch switchCamaras;

    private TextView textViewStatus;

    private SeekBar slider;
    private int numero = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        Button botonRestar = findViewById(R.id.botonRestar);
        Button botonSumar = findViewById(R.id.botonSumar);

        switchCamaras = findViewById(R.id.switchCamaras);
        textViewStatus = findViewById(R.id.textViewStatus);

        slider = findViewById(R.id.slider);

        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setBackgroundColor(getResources().getColor(R.color.azulSielo));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Aquí puedes agregar lógica adicional si lo deseas
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Cambiar el color del thumb (pulgar) cuando está en los extremos
                if (seekBar.getProgress() == seekBar.getMax()) {
                    seekBar.setBackgroundColor(getResources().getColor(R.color.rojo));
                } else if(seekBar.getProgress() == seekBar.getMin()){
                    seekBar.setBackgroundColor(getResources().getColor(R.color.black));
                }
            }
        });

        switchCamaras.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textViewStatus.setText("On");
                } else {
                    textViewStatus.setText("Off");
                }
            }
        });

        botonRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero--;
                actualizarTextView();
                colorTemperatura();
            }
        });

        botonSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero++;
                actualizarTextView();
                colorTemperatura();
            }
        });
    }

    private void actualizarTextView() {
        textView.setText(String.valueOf(numero)+"ºC");
    }

    private void colorTemperatura(){
        if(numero<15){
            textView.setTextColor(getResources().getColor(R.color.cool));
        }else if(numero<28){
            textView.setTextColor(getResources().getColor(R.color.green));
        }else{
            textView.setTextColor(getResources().getColor(R.color.rojo));
        }
    }
}

