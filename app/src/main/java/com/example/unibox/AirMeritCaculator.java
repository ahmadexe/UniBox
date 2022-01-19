package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AirMeritCaculator extends AppCompatActivity {
    EditText matricAir;
    EditText matricTotalAir;
    EditText fscAir;
    EditText fscTotalAir;
    EditText testAir;
    EditText testTotalAir;

    TextView resultAir;

    Button calculateAir;
    boolean matricVerification = false;
    boolean fscVerification = false;
    boolean testVerification = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_merit_caculator);
        matricAir = findViewById(R.id.matricAir);
        matricTotalAir = findViewById(R.id.totalMatricMarksAir);

        fscAir = findViewById(R.id.fscAir);
        fscTotalAir = findViewById(R.id.fscTotalAir);

        testAir = findViewById(R.id.testAir);
        testTotalAir = findViewById(R.id.testTotalAir);

        resultAir = findViewById(R.id.resultAir);

        calculateAir = findViewById(R.id.calculateAir);
        
        

        calculateAir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //test
                    double marksTestAir = Double.parseDouble(testAir.getText().toString());
                    double marksTestTotalAir = Double.parseDouble(testTotalAir.getText().toString());
                    double percentageTestAir = (marksTestAir/marksTestTotalAir) * 100;
                    double formulaTestAir = percentageTestAir * (50.0/100.0);
                    if (marksTestAir <= marksTestTotalAir && marksTestTotalAir <= 2000){
                        testVerification = true;
                    }

                    //matric
                    double marksMatricAir = Double.parseDouble(matricAir.getText().toString());
                    double marksMatricTotalAir = Double.parseDouble(matricTotalAir.getText().toString());
                    double percentageMatricAir = (marksMatricAir/marksMatricTotalAir) * 100;
                    double formulaMatricAir = percentageMatricAir * (15.0/100.0);
                    if (marksMatricAir <= marksMatricTotalAir && marksMatricTotalAir <= 2000){
                        matricVerification = true;
                    }

                    // FSc
                    double fscAirMarks = Double.parseDouble(fscAir.getText().toString());
                    double fscAirTotal = Double.parseDouble(fscTotalAir.getText().toString());
                    double percentageFscAir = (fscAirMarks/fscAirTotal) * 100;
                    double formulaFscAir = percentageFscAir * (35.0/100.0);
                    if (fscAirMarks <= fscAirTotal && fscAirTotal <= 2000){
                        fscVerification = true;
                    }
                    // total
                    double aggregateAir = formulaFscAir + formulaMatricAir + formulaTestAir;
                    if (testVerification && matricVerification && fscVerification){
                        resultAir.setText("Your aggregate is: "+aggregateAir+"%");
                    }
                    else{
                        Toast.makeText(AirMeritCaculator.this, "Invalid Inputs! Enter valid inputs", Toast.LENGTH_SHORT).show();
                        resultAir.setText(" ");
                    }
                }
                catch (Exception e){
                    Toast.makeText(AirMeritCaculator.this, "Enter valid inputs!", Toast.LENGTH_SHORT).show();
                }
                testVerification = false;
                matricVerification = false;
                fscVerification = false;
            }

        });

    }
}