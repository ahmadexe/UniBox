package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MeritCalculatorPmc extends AppCompatActivity {
    EditText matricPmc;
    EditText matricTotalPmc;

    EditText fscPmc;
    EditText fscTotalPmc;

    EditText testPmc;
    EditText testTotalPmc;

    TextView showResultPmc;

    Button calculatePmc;

    boolean matricVerification = false;
    boolean fscVerification = false;
    boolean testVerification = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merit_calculator_pmc);

        matricPmc = findViewById(R.id.matricAku);
        matricTotalPmc = findViewById(R.id.matricTotalAku);

        fscPmc = findViewById(R.id.fscAku);
        fscTotalPmc = findViewById(R.id.fscTotalAku);

        testPmc = findViewById(R.id.testAku);
        testTotalPmc = findViewById(R.id.testTotalAku);

        showResultPmc = findViewById(R.id.showResultAku);
        calculatePmc = findViewById(R.id.calculateAku);

        calculatePmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //test
                    double marksTestPmc = Double.parseDouble(testPmc.getText().toString());
                    double marksTestTotalPmc = Double.parseDouble(testTotalPmc.getText().toString());
                    double percentageTestPmc = (marksTestPmc/marksTestTotalPmc) * 100;
                    double formulaTest = percentageTestPmc * (50.0/100.0);
                    if (marksTestPmc <= marksTestTotalPmc && marksTestTotalPmc <= 2000){
                        testVerification = true;
                    }
                    //matric
                    double marksMatricPmc = Double.parseDouble(matricPmc.getText().toString());
                    double marksMatricTotalPmc = Double.parseDouble(matricTotalPmc.getText().toString());
                    double percentageMatricPmc = (marksMatricPmc/marksMatricTotalPmc) * 100;
                    double formulaMatric = percentageMatricPmc * (10.0/100.0);
                    if (marksMatricPmc <= marksMatricTotalPmc && marksMatricTotalPmc <= 2000){
                        matricVerification = true;
                    }

                    // FSc
                    double fscMarksPmc = Double.parseDouble(fscPmc.getText().toString());
                    double fscMarksTotalPmc = Double.parseDouble(fscTotalPmc.getText().toString());
                    double percentageFscPmc = (fscMarksPmc/fscMarksTotalPmc) * 100;
                    double formulaFsc = percentageFscPmc * (40.0/100.0);
                    if (fscMarksPmc <= fscMarksTotalPmc && fscMarksTotalPmc <= 2000){
                        fscVerification = true;
                    }
                    // total
                    double aggregatePmc = formulaFsc + formulaMatric + formulaTest;
                    if (fscVerification && testVerification && matricVerification) {
                        showResultPmc.setText("Your aggregate is: " + aggregatePmc + "%");
                    }
                    else{
                        showResultPmc.setText(" ");
                        Toast.makeText(MeritCalculatorPmc.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(MeritCalculatorPmc.this, "Enter Valid input", Toast.LENGTH_SHORT).show();
                }
                matricVerification = false;
                fscVerification = false;
                testVerification = false;
            }
        });

    }

    public void openPmcSearchWindow(View v){
        Intent intent = new Intent(this, PmcMeritSearch.class);
        startActivity(intent);
    }
}