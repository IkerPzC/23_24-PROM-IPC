package com.example.ejercicio2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1, button2;
        final RelativeLayout relativeLayout;

        // set button 1 with its id
        button1 = findViewById(R.id.btVar1);

        // set button 2 with its id
        button2 = findViewById(R.id.btVar2);

        // set relative layout with its id
        relativeLayout = findViewById(R.id.rlVar1);

        // onClick boton1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayout.setBackgroundResource(R.color.cool);
            }
        });

        // onClick boton2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayout.setBackgroundResource(R.color.green);
            }
        });
    }
}

