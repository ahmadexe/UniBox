package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FastMeritCalculator extends AppCompatActivity {
    EditText fscFast;
    EditText fscTotalFast;
    
    EditText testFast;
    EditText testTotalFast;
    
    TextView showResultFast;

    Button calculateFast;

    boolean fscVerification = false;
    boolean testVerification = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_merit_calculator);
        
        fscFast = findViewById(R.id.matricAku);
        fscTotalFast = findViewById(R.id.matricTotalAku);
        
        testFast = findViewById(R.id.fscAku);
        testTotalFast = findViewById(R.id.fscTotalAku);
        
        showResultFast = findViewById(R.id.showResultPucit);
        
        calculateFast = findViewById(R.id.calculatePucit);
        
        calculateFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double testObtainFast = Double.parseDouble(testFast.getText().toString());
                    double testTotalMarksFast = Double.parseDouble(testTotalFast.getText().toString());
                    double percentageTestFast = (testObtainFast / testTotalMarksFast) * 100;
                    double formulaTestFast = percentageTestFast * (50.0 / 100.0);
                    if (testObtainFast <= testTotalMarksFast && testTotalMarksFast <= 2000){
                        testVerification = true;
                    }

                    double fscMarksFast = Double.parseDouble(fscFast.getText().toString());
                    double fscMarksTotalFast = Double.parseDouble(fscTotalFast.getText().toString());
                    double percentageFscFast = (fscMarksFast / fscMarksTotalFast) * 100;
                    double formulaFscFast = percentageFscFast * (50.0 / 100.0);
                    if (fscMarksFast <= fscMarksTotalFast && fscMarksTotalFast <= 2000){
                        fscVerification = true;
                    }

                    double endResult = formulaFscFast + formulaTestFast;
                    if (testVerification && fscVerification) {
                        showResultFast.setText("Your aggregate is " + endResult + "%");
                    }
                    else{
                        showResultFast.setText(" ");
                        Toast.makeText(FastMeritCalculator.this, "Invalid Inputs", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(FastMeritCalculator.this, "Enter valid inputs.", Toast.LENGTH_SHORT).show();
                }
                fscVerification = false;
                testVerification = false;
            }
        });
    }

    public void openFastSearch(View v){
        Intent intent = new Intent(this, FastMeritSearch.class);
        startActivity(intent);
    }
}