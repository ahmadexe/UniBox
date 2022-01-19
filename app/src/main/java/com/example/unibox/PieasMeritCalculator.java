package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PieasMeritCalculator extends AppCompatActivity {
    EditText testPieas;
    EditText testPieasTotal;
    EditText matric;
    EditText matricTotal;
    EditText fsc;
    EditText fscTotal;
    TextView showResult;
    Button calculate;
    boolean matricVerification = false;
    boolean fscVerification = false;
    boolean testVerification = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pieas_merit_calculator);
        testPieas = findViewById(R.id.marksEntryTestPieas);
        testPieasTotal = findViewById(R.id.totalMarksinTestPieas);
        matric = findViewById(R.id.marksMatricPieas);
        matricTotal = findViewById(R.id.totalMatricPieas);
        fsc = findViewById(R.id.marksInFscPieas);
        fscTotal = findViewById(R.id.totalFscMarksPieas);
        showResult = findViewById(R.id.resultPieas);
        calculate = findViewById(R.id.resultCalculatePieas);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //test
                    double marksTestPieas = Double.parseDouble(testPieas.getText().toString());
                    double marksTestTotalPieas = Double.parseDouble(testPieasTotal.getText().toString());
                    double percentageTest = (marksTestPieas/marksTestTotalPieas) * 100;
                    double formulaTest = percentageTest * (60.0/100.0);
                    if (marksTestPieas <= marksTestTotalPieas && marksTestTotalPieas <= 2000){
                        testVerification = true;
                    }
                    //matric
                    double marksMatricPieas = Double.parseDouble(matric.getText().toString());
                    double marksMatricTotalPieas = Double.parseDouble(matricTotal.getText().toString());
                    double percentageMatric = (marksMatricPieas/marksMatricTotalPieas) * 100;
                    double formulaMatric = percentageMatric * (15.0/100.0);
                    if (marksMatricPieas <= marksMatricTotalPieas && marksMatricTotalPieas <= 2000){
                        matricVerification = true;
                    }

                    // FSc
                    double fscPieas = Double.parseDouble(fsc.getText().toString());
                    double fscPieasTotal = Double.parseDouble(fscTotal.getText().toString());
                    double percentageFsc = (fscPieas/fscPieasTotal) * 100;
                    double formulaFsc = percentageFsc * (25.0/100.0);
                    if (fscPieas <= fscPieasTotal && fscPieasTotal <= 2000){
                        fscVerification = true;
                    }
                    // total
                    double aggregatePieas = formulaFsc + formulaMatric + formulaTest;
                    if (testVerification && fscVerification && testVerification) {
                        showResult.setText("Your aggregate is: " + aggregatePieas + "%");
                    }
                    else{
                        showResult.setText(" ");
                        Toast.makeText(PieasMeritCalculator.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(PieasMeritCalculator.this, "Enter valid inputs", Toast.LENGTH_SHORT).show();
                }
                matricVerification = false;
                fscVerification = false;
                testVerification = false;
            }
        });
    }

    public void pieasSearchWindowOpen(View v){
        Intent intent = new Intent(this, PieasMeritSearch.class);
        startActivity(intent);
    }
}