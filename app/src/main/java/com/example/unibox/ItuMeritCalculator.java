package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ItuMeritCalculator extends AppCompatActivity {
    EditText matricItu;
    EditText matricTotalItu;

    EditText fscItu;
    EditText fscTotalItu;

    EditText testItu;
    EditText testTotalItu;

    EditText interviewItu;
    EditText interviewTotalItu;

    TextView showResultItu;

    Button calculateItu;
    boolean matricVerification = false;
    boolean fscVerification = false;
    boolean testVerification = false;
    boolean interviewVarification = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itu_merit_calculator);

        matricItu = findViewById(R.id.matricItu);
        matricTotalItu = findViewById(R.id.matricTotalItu);

        fscItu = findViewById(R.id.fscItu);
        fscTotalItu = findViewById(R.id.fscTotalItu);

        testItu = findViewById(R.id.testItu);
        testTotalItu = findViewById(R.id.testTotalItu);

        interviewItu = findViewById(R.id.interviewItu);
        interviewTotalItu = findViewById(R.id.interviewTotalItu);

        showResultItu = findViewById(R.id.showResultItu);
        calculateItu = findViewById(R.id.calculateItu);

        calculateItu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //test
                    double marksTestItu = Double.parseDouble(testItu.getText().toString());
                    double marksTestTotalItu = Double.parseDouble(testTotalItu.getText().toString());
                    double percentageTestItu = (marksTestItu/marksTestTotalItu) * 100;
                    double formulaTest = percentageTestItu * (40.0/100.0);
                    if (marksTestItu <= marksTestTotalItu && marksTestTotalItu <= 2000){
                        testVerification = true;
                    }

                    //matric
                    double marksMatricItu = Double.parseDouble(matricItu.getText().toString());
                    double marksMatricTotalItu = Double.parseDouble(matricTotalItu.getText().toString());
                    double percentageMatricItu = (marksMatricItu/marksMatricTotalItu) * 100;
                    double formulaMatric = percentageMatricItu * (20.0/100.0);
                    if (marksMatricItu <= marksMatricTotalItu && marksMatricTotalItu <= 2000){
                        matricVerification = true;
                    }

                    // FSc
                    double fscMarksItu = Double.parseDouble(fscItu.getText().toString());
                    double fscMarksTotalItu = Double.parseDouble(fscTotalItu.getText().toString());
                    double percentageFscItu = (fscMarksItu/fscMarksTotalItu) * 100;
                    double formulaFsc = percentageFscItu * (20.0/100.0);
                    if (fscMarksItu <= fscMarksTotalItu && fscMarksTotalItu <= 2000){
                        fscVerification = true;
                    }

                    // Interview
                    double interviewMarksItu = Double.parseDouble(interviewItu.getText().toString());
                    double interviewMarksTotalItu = Double.parseDouble(interviewTotalItu.getText().toString());
                    double percentageInterviewItu = (interviewMarksItu/interviewMarksTotalItu) * 100;
                    double formulaInterview = percentageInterviewItu * (20.0/100.0);
                    if (interviewMarksItu <= interviewMarksTotalItu && interviewMarksTotalItu <= 2000){
                        interviewVarification = true;
                    }

                    // total
                    double aggregateItu = formulaFsc + formulaMatric + formulaTest + formulaInterview;
                    if (testVerification && matricVerification && fscVerification && interviewVarification) {
                        showResultItu.setText("Your aggregate is: " + aggregateItu + "%");
                    }
                    else{
                        showResultItu.setText(" ");
                        Toast.makeText(ItuMeritCalculator.this, "Invalid inputs!", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(ItuMeritCalculator.this, "Enter Valid input", Toast.LENGTH_SHORT).show();
                }
                matricVerification = false;
                fscVerification = false;
                testVerification = false;
                interviewVarification = false;
            }
        });
    }
}