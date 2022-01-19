package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MeritCalculatorNust extends AppCompatActivity {
    EditText netMarks;
    EditText netTotal;
    EditText matricMarks;
    EditText matricTotal;
    TextView result;
    Button calculate;
    boolean matricVerification = false;
    boolean testVerification = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merit_calculator_nust);
        netMarks = findViewById(R.id.fscAku);
        netTotal = findViewById(R.id.fscTotalAku);
        matricMarks = findViewById(R.id.matricAku);
        matricTotal = findViewById(R.id.matricTotalAku);
        result = findViewById(R.id.showResultPucit);
        calculate = findViewById(R.id.calculatePucit);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double netObtained = Double.parseDouble(netMarks.getText().toString());
                    double netTotalMarks = Double.parseDouble(netTotal.getText().toString());
                    double percentageNet = (netObtained / netTotalMarks) * 100;
                    double formulaNet = percentageNet * (75.0 / 100.0);
                    if (netObtained <= netTotalMarks && netTotalMarks <= 2000){
                        testVerification = true;
                    }
                    double matricMarksObtained = Double.parseDouble(matricMarks.getText().toString());
                    double matricTotalMarks = Double.parseDouble(matricTotal.getText().toString());
                    double percentageMatric = (matricMarksObtained / matricTotalMarks) * 100;
                    double formulaMatric = percentageMatric * (25.0 / 100.0);
                    if (matricMarksObtained <= matricTotalMarks && matricTotalMarks <= 2000){
                        matricVerification = true;
                    }

                    double endResult = formulaMatric + formulaNet;
                    if(testVerification && matricVerification) {
                        result.setText("Your aggregate is " + endResult + "%");
                    }
                    else{
                        result.setText(" ");
                        Toast.makeText(MeritCalculatorNust.this, "Invalid Input!", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(MeritCalculatorNust.this, "Couldn't calculate result, enter valid inputs.", Toast.LENGTH_SHORT).show();
                }
                testVerification = false;
                matricVerification = false;
            }
        });

    }

}