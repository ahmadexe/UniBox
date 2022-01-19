package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UetMeritCalculator extends AppCompatActivity {
    EditText marksMatricUET;
    EditText marksMatricUETTotal;
    EditText marksEcatUET;
    EditText marksEcatUETTotal;
    
    TextView showResultUET;
    
    Button calculateResultUET;
    boolean matricVerification = false;
    boolean testVerification = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uet_merit_calculator);
        marksMatricUET = findViewById(R.id.matricUET);
        marksMatricUETTotal = findViewById(R.id.matricTotalUET);
        
        marksEcatUET = findViewById(R.id.ecatUET);
        marksEcatUETTotal = findViewById(R.id.ecatUETTotal);
        
        showResultUET = findViewById(R.id.resultDisplayUET);
        
        calculateResultUET = findViewById(R.id.calculateUET);
        
        calculateResultUET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double ecatObtainedUET = Double.parseDouble(marksEcatUET.getText().toString());
                    double ecatTotalUET = Double.parseDouble(marksEcatUETTotal.getText().toString());
                    double percentageEcatUET = (ecatObtainedUET / ecatTotalUET) * 100;
                    double formulaEcatUET = percentageEcatUET * (30.0 / 100.0);
                    if (ecatObtainedUET <= ecatTotalUET && ecatTotalUET <= 2000){
                        testVerification = true;
                    }

                    double matricMarksObtainedUET = Double.parseDouble(marksMatricUET.getText().toString());
                    double matricTotalMarksUET = Double.parseDouble(marksMatricUETTotal.getText().toString());
                    double percentageMatricUET = (matricMarksObtainedUET / matricTotalMarksUET) * 100;
                    double formulaMatricUET = percentageMatricUET * (70.0 / 100.0);
                    if (matricMarksObtainedUET <= matricTotalMarksUET && matricTotalMarksUET <= 2000){
                        matricVerification = true;
                    }
                    double endResult = formulaMatricUET + formulaEcatUET;
                    if (testVerification && matricVerification) {
                        showResultUET.setText("Your aggregate is " + endResult + "%");
                    }
                    else{
                        showResultUET.setText(" ");
                        Toast.makeText(UetMeritCalculator.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(UetMeritCalculator.this, "Enter valid inputs!", Toast.LENGTH_SHORT).show();
                }
                testVerification = false;
                matricVerification = false;
            }
        });
    }

    public void openingUetMeritWindow(View v){
        Intent intent = new Intent(this, UetMeritSearch.class);
        startActivity(intent);
    }
}