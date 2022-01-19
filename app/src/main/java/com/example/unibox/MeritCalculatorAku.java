package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MeritCalculatorAku extends AppCompatActivity {

    EditText matricAku;
    EditText matricTotalAku;

    EditText fscAku;
    EditText fscTotalAku;

    EditText testAku;
    EditText testTotalAku;

    TextView showResultAku;

    Button calculateAku;
    boolean matricVerification = false;
    boolean fscVerification = false;
    boolean testVerification = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merit_calculator_aku);

        matricAku = findViewById(R.id.matricAku);
        matricTotalAku = findViewById(R.id.matricTotalAku);
        fscAku = findViewById(R.id.fscAku);
        fscTotalAku = findViewById(R.id.fscTotalAku);
        testAku = findViewById(R.id.testAku);
        testTotalAku = findViewById(R.id.testTotalAku);
        showResultAku = findViewById(R.id.showResultAku);
        calculateAku = findViewById(R.id.calculateAku);
        calculateAku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //test
                    double marksTestAku = Double.parseDouble(testAku.getText().toString());
                    double marksTestTotalAku = Double.parseDouble(testTotalAku.getText().toString());
                    double percentageTestAku = (marksTestAku/marksTestTotalAku) * 100;
                    double formulaTest = percentageTestAku * (50.0/100.0);
                    if (marksTestAku <= marksTestTotalAku && marksTestTotalAku <= 2000){
                        testVerification = true;
                    }

                    //matric
                    double marksMatricAku = Double.parseDouble(matricAku.getText().toString());
                    double marksMatricTotalAku = Double.parseDouble(matricTotalAku.getText().toString());
                    double percentageMatricAku = (marksMatricAku/marksMatricTotalAku) * 100;
                    double formulaMatric = percentageMatricAku * (10.0/100.0);
                    if (marksMatricAku <= marksMatricTotalAku && marksMatricTotalAku <= 2000){
                        matricVerification = true;
                    }

                    // FSc
                    double fscMarksAku = Double.parseDouble(fscAku.getText().toString());
                    double fscMarksTotalAku = Double.parseDouble(fscTotalAku.getText().toString());
                    double percentageFscAku = (fscMarksAku/fscMarksTotalAku) * 100;
                    double formulaFsc = percentageFscAku * (40.0/100.0);
                    if (fscMarksAku <= fscMarksTotalAku && fscMarksTotalAku <= 2000){
                        fscVerification = true;
                    }
                    // total
                    double aggregateAku = formulaFsc + formulaMatric + formulaTest;
                    if (testVerification && matricVerification && fscVerification) {
                        showResultAku.setText("Your aggregate is: "+aggregateAku+"%");

                    }

                    else {
                        showResultAku.setText(" ");
                        Toast.makeText(MeritCalculatorAku.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(MeritCalculatorAku.this, "Enter Valid input", Toast.LENGTH_SHORT).show();
                }
                matricVerification = false;
                fscVerification = false;
                testVerification = false;
            }
        });
    }
}