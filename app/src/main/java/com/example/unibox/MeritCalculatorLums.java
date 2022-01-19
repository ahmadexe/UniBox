package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MeritCalculatorLums extends AppCompatActivity {
    EditText satLums;
    EditText satTotalLums;

    TextView showResultLums;

    Button calculateLums;
    boolean testVerification = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merit_calculator_lums);
        satLums = findViewById(R.id.satIba);
        satTotalLums = findViewById(R.id.satTotalIba);

        showResultLums = findViewById(R.id.showResultIba);

        calculateLums = findViewById(R.id.calculateIba);
        calculateLums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double marksInSat = Double.parseDouble(satLums.getText().toString());
                    double marksSatTotal = Double.parseDouble(satTotalLums.getText().toString());
                    double percentageSatLums = (marksInSat / marksSatTotal) * 100;
                    if (marksInSat <= marksSatTotal && marksSatTotal <= 2000) {
                        showResultLums.setText("Your SAT percentage is " + percentageSatLums + "%");
                    }
                    else{
                        showResultLums.setText(" ");
                        Toast.makeText(MeritCalculatorLums.this, "Invalid input!", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e) {
                    Toast.makeText(MeritCalculatorLums.this, "Enter valid numeric inputs", Toast.LENGTH_SHORT).show();
                }
                testVerification = false;
            }
        });
    }
}