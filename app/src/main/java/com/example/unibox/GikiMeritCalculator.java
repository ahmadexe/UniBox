package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GikiMeritCalculator extends AppCompatActivity {
    EditText gikiMatric;
    EditText gikiMatricTotal;
    EditText gikiFsc;
    EditText gikiFscTotal;
    EditText gikiTest;
    EditText gikiTestTotal;

    TextView showResultGiki;

    Button calculateResultGiki;

    boolean matricVerification = false;
    boolean fscVerification = false;
    boolean testVerification = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giki_merit_calculator);
        gikiMatric = findViewById(R.id.marksMatricGiki);
        gikiMatricTotal = findViewById(R.id.matricTotalGiki);

        gikiFsc = findViewById(R.id.marksFscGiki);
        gikiFscTotal = findViewById(R.id.fscTotalGiki);

        gikiTest = findViewById(R.id.testMarksGiki);
        gikiTestTotal = findViewById(R.id.testTotalGiki);

        showResultGiki = findViewById(R.id.resultDisplayGiki);

        calculateResultGiki = findViewById(R.id.calculateResultGiki);

        calculateResultGiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //test
                    double marksTestGiki = Double.parseDouble(gikiTest.getText().toString());
                    double marksTotalTestGiki = Double.parseDouble(gikiTestTotal.getText().toString());
                    double percentageTestGiki = (marksTestGiki/marksTotalTestGiki) * 100;
                    double formulaTestGiki = percentageTestGiki * (85.0/100.0);
                    if (marksTestGiki <= marksTotalTestGiki && marksTotalTestGiki <= 2000){
                        testVerification = true;
                    }

                    //matric
                    double marksMatricGiki = Double.parseDouble(gikiMatric.getText().toString());
                    double marksMatricTotalGiki = Double.parseDouble(gikiMatricTotal.getText().toString());
                    double percentageMatricGiki = (marksMatricGiki/marksMatricTotalGiki) * 100;
                    double formulaMatricGiki = percentageMatricGiki * (5.0/100.0);
                    if (marksMatricGiki <= marksMatricTotalGiki && marksMatricTotalGiki <= 2000){
                        matricVerification = true;
                    }

                    // FSc
                    double fscGiki = Double.parseDouble(gikiFsc.getText().toString());
                    double fscGikiTotal = Double.parseDouble(gikiFscTotal.getText().toString());
                    double percentageFscGiki = (fscGiki/fscGikiTotal) * 100;
                    double formulaFscGiki = percentageFscGiki * (10.0/100.0);
                    if (fscGiki <= fscGikiTotal && fscGikiTotal <= 2000){
                        fscVerification = true;
                    }

                    // total
                    double aggregateGiki = formulaFscGiki + formulaMatricGiki + formulaTestGiki;
                    if (testVerification && matricVerification && fscVerification) {
                        showResultGiki.setText("Your aggregate is: " + aggregateGiki + "%");
                    }
                    else {
                        showResultGiki.setText(" ");
                        Toast.makeText(GikiMeritCalculator.this, "Invalid inputs", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(GikiMeritCalculator.this, "Enter valid inputs", Toast.LENGTH_SHORT).show();
                }
                matricVerification = false;
                fscVerification = false;
                testVerification = false;
            }
        });
    }
}