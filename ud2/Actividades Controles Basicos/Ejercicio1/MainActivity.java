package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void botonSuma (View v){
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        TextView resultTextView = findViewById(R.id.resultTextView);

        try {
            double num1 = Double.parseDouble(editText1.getText().toString());
            double num2 = Double.parseDouble(editText2.getText().toString());
            resultTextView.setText((num1+num2)+"");
        }catch (NumberFormatException e){
            resultTextView.setText("Introduce números!");
        }


    }
    public void botonResta (View v){
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        TextView resultTextView = findViewById(R.id.resultTextView);

        try {
            double num1 = Double.parseDouble(editText1.getText().toString());
            double num2 = Double.parseDouble(editText2.getText().toString());
            resultTextView.setText((num1-num2)+"");
        }catch (NumberFormatException e){
            resultTextView.setText("Introduce números!");
        }
    }

    public void botonMultiplicacion (View v){
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        TextView resultTextView = findViewById(R.id.resultTextView);

        try {
            double num1 = Double.parseDouble(editText1.getText().toString());
            double num2 = Double.parseDouble(editText2.getText().toString());
            resultTextView.setText((num1*num2)+"");
        }catch (NumberFormatException e){
            resultTextView.setText("Introduce números!");
        }
    }

    public void botonDivision (View v){
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        TextView resultTextView = findViewById(R.id.resultTextView);

        try {
            double num1 = Double.parseDouble(editText1.getText().toString());
            double num2 = Double.parseDouble(editText2.getText().toString());
            if(num2!=0){
                resultTextView.setText((num1/num2)+"");
            }else{
                resultTextView.setText("DIVISION POR CERO!!");
            }
        }catch (NumberFormatException e){
            resultTextView.setText("Introduce números!");
        }


    }
}
