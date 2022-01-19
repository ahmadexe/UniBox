package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ComsatsMeritCalculator extends AppCompatActivity {
    EditText matricComsats;
    EditText matricTotalComsats;

    EditText fscComsats;
    EditText fscTotalComsats;

    EditText testComsats;
    EditText testTotalComsats;

    TextView showResultComsats;

    Button calculateComsats;

    Button meritCheckOpen;

    boolean matricVerification = false;
    boolean fscVerification = false;
    boolean testVerification = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comsats_merit_calculator);
        meritCheckOpen = findViewById(R.id.meritCheckOpen);
        matricComsats = findViewById(R.id.matricAku);
        matricTotalComsats = findViewById(R.id.matricTotalAku);

        fscComsats = findViewById(R.id.fscAku);
        fscTotalComsats = findViewById(R.id.fscTotalAku);

        testComsats = findViewById(R.id.testAku);
        testTotalComsats = findViewById(R.id.testTotalAku);

        showResultComsats = findViewById(R.id.showResultAku);

        calculateComsats = findViewById(R.id.calculateAku);

        calculateComsats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //test
                    double marksTestComsats = Double.parseDouble(testComsats.getText().toString());
                    double marksTestTotalComsats = Double.parseDouble(testTotalComsats.getText().toString());
                    double percentageTest = (marksTestComsats/marksTestTotalComsats) * 100;
                    double formulaTest = percentageTest * (50.0/100.0);
                    if (marksTestComsats <= marksTestTotalComsats && marksTestTotalComsats <= 2000){
                        testVerification = true;
                    }
                    //matric
                    double marksMatricComsats = Double.parseDouble(matricComsats.getText().toString());
                    double marksMatricTotalComsats = Double.parseDouble(matricTotalComsats.getText().toString());
                    double percentageMatric = (marksMatricComsats/marksMatricTotalComsats) * 100;
                    double formulaMatric = percentageMatric * (10.0/100.0);
                    if (marksMatricComsats <= marksMatricTotalComsats && marksMatricTotalComsats <= 2000){
                        matricVerification = true;
                    }

                    // FSc
                    double fscMarksComsats = Double.parseDouble(fscComsats.getText().toString());
                    double fscMarksTotalComsats = Double.parseDouble(fscTotalComsats.getText().toString());
                    double percentageFsc = (fscMarksComsats/fscMarksTotalComsats) * 100;
                    double formulaFsc = percentageFsc * (40.0/100.0);
                    if (fscMarksComsats <= fscMarksTotalComsats && fscMarksTotalComsats <= 2000){
                        fscVerification = true;
                    }
                    // total
                    double aggregateComsats = formulaFsc + formulaMatric + formulaTest;
                    if (testVerification && fscVerification && matricVerification){
                        showResultComsats.setText("Your aggregate is: "+aggregateComsats+"%");
                    }
                    else{
                        Toast.makeText(ComsatsMeritCalculator.this, "Invalid Inputs!", Toast.LENGTH_SHORT).show();
                        showResultComsats.setText(" ");
                    }
                }
                catch (Exception e){
                    Toast.makeText(ComsatsMeritCalculator.this, "Enter Valid input", Toast.LENGTH_SHORT).show();
                }
                testVerification = false;
                matricVerification = false;
                fscVerification = false;
            }
        });

    }

    public void openSearchMeritWindowComsats(View v){
        Intent intent = new Intent(this, ComsatsSearchMerit.class);
        startActivity(intent);
    }
}