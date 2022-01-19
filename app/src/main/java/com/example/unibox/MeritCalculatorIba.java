package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MeritCalculatorIba extends AppCompatActivity {
    EditText satIba;
    EditText satTotalIba;

    TextView showResultIba;

    Button calculateIba;

    boolean testVerification = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merit_calculator_iba);

        satIba = findViewById(R.id.satIba);
        satTotalIba = findViewById(R.id.satTotalIba);
        showResultIba = findViewById(R.id.showResultIba);
        calculateIba = findViewById(R.id.calculateIba);

        calculateIba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double marksInSatIba = Double.parseDouble(satIba.getText().toString());
                    double marksSatTotalIba = Double.parseDouble(satTotalIba.getText().toString());
                    double percentageSatIba = (marksInSatIba / marksSatTotalIba) * 100;
                    if (marksInSatIba <= marksSatTotalIba && marksSatTotalIba <= 2000) {
                        showResultIba.setText("Your SAT percentage is " + percentageSatIba + "%");
                    }
                    else {
                        Toast.makeText(MeritCalculatorIba.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                        showResultIba.setText(" ");
                    }
                }
                catch (Exception e) {
                    Toast.makeText(MeritCalculatorIba.this, "Enter valid numeric inputs", Toast.LENGTH_SHORT).show();
                }
                testVerification = false;
            }
        });
    }
}