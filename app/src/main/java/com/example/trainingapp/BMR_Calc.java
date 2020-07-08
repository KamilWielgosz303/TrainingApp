package com.example.trainingapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Math.pow;

public class BMR_Calc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr_calc);
    }

    public void calculateBMR(View view) {
        TextView weightName = findViewById(R.id.bmrWeight);
        TextView growthName = findViewById(R.id.bmrGrowth);
        TextView ageName = findViewById(R.id.bmrAge);
        try {
            Integer weight = Integer.parseInt(weightName.getText().toString());
            Integer growth = Integer.parseInt(growthName.getText().toString());
            Integer age = Integer.parseInt(ageName.getText().toString());
            Double bmr = 9.99 * weight + 6.25 * growth - 4.92 * age + 5;
            TextView result = findViewById(R.id.bmrResult);
            result.setText(String.format("%.2f", bmr));
        }catch(Exception ex){
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.exception),Toast.LENGTH_LONG).show();
        }

    }
}
