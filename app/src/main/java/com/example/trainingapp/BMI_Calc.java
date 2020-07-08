package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.pow;

public class BMI_Calc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi__calc);
        weightDescription = new String[5];
        weightDescription[0]=getResources().getString(R.string.BMI_Discription_Underweight);
                weightDescription[1]=getResources().getString(R.string.BMI_Discription_Normal_weight);
                weightDescription[2]=getResources().getString(R.string.BMI_Discription_Overweight);
                weightDescription[3]=getResources().getString(R.string.BMI_Discription_Obese);
                weightDescription[4]= getResources().getString(R.string.BMI_Discription_Morbidly_Obese);
    }

    private String[] weightDescription;

    public void calculateBMI(View view) {
        TextView weight = findViewById(R.id.bmiWeight);
        TextView growth = findViewById(R.id.bmiGrowth);
        try {
            Integer a = Integer.parseInt(weight.getText().toString());
            Double b = Double.parseDouble(growth.getText().toString());
            Double bmi = a / pow(b / 100, 2);
            TextView result = findViewById(R.id.bmiResult);
            result.setText(String.format("%.2f",bmi));

            TextView desc = findViewById(R.id.weightDesc);
            desc.setText(chooseDecription(bmi));

        }catch(Exception ex){
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.exception),Toast.LENGTH_LONG).show();
        }
    }

    private String chooseDecription(Double bmi) {           //Wybieranie opisu i koloru na podstawie bmi
        String description;
        TextView desc = findViewById(R.id.weightDesc);
        if (bmi < 18.5) {
            description = weightDescription[0];
            desc.setTextColor(Color.RED);
        } else if (bmi >= 18.5 && bmi < 25) {
            description = weightDescription[1];
            desc.setTextColor(Color.GREEN);
        } else if (bmi >= 25 && bmi < 30) {
            description = weightDescription[2];
            desc.setTextColor(Color.BLUE);
        } else if (bmi >= 30 && bmi < 40) {
            description = weightDescription[3];
            desc.setTextColor(Color.YELLOW);
        } else {
            description = weightDescription[4];
            desc.setTextColor(Color.RED);
        }
        return description;
    }
}
