package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imageView;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);

        button3 = findViewById(R.id.button3);

        //FORMA 3
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambiar la imagen de manera diferente para el Botón 3
                imageView.setImageResource(R.drawable.google);
            }
        });
    }

    //FORMA 2
    public void onClick(View v){
        imageView.setImageResource(R.drawable.bing);
    }

    //FORMA 1
    public void boton1pulsado(View v){
        imageView.setImageResource(R.drawable.yahoo);
    }
}

