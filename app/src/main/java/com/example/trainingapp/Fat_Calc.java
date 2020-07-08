package com.example.trainingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Fat_Calc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_calc);
    }
    public void calculateFat(View view) {
        TextView weightName = findViewById(R.id.fatWeight);
        TextView waistName = findViewById(R.id.fatWaist);
        RadioButton manbutton = findViewById(R.id.manButton);
        RadioButton womanbutton = findViewById(R.id.womanButton);
        try {
            Integer weight = Integer.parseInt(weightName.getText().toString());
            Integer waist = Integer.parseInt(waistName.getText().toString());
            Double x;
            if(manbutton.isChecked())
                x = 98.42;
            else if(womanbutton.isChecked())
                x = 76.76;
            else
                throw new Exception();


            Double fat = ((((4.15*waist)/2.54) - (0.082*weight*2.2) - x)/(weight*2.2))*100;
            TextView result = findViewById(R.id.fatResult);
            result.setText(String.format("%.2f", fat));
        }catch(Exception ex){
            Toast.makeText(getApplicationContext(),getResources().getString(R.string.exception),Toast.LENGTH_LONG).show();
        }
    }
}
