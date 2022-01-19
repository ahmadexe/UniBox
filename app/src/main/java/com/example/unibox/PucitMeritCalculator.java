package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PucitMeritCalculator extends AppCompatActivity {
    EditText fscPucit;
    EditText fscTotalPucit;

    EditText matricPucit;
    EditText matricTotalPucit;

    TextView showResultPucit;

    Button calculatePucit;
    Button meritSearch;
    boolean matricVerification = false;
    boolean fscVerification = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pucit_merit_calculator);

        fscPucit = findViewById(R.id.matricAku);
        fscTotalPucit = findViewById(R.id.matricTotalAku);

        matricPucit = findViewById(R.id.fscAku);
        matricTotalPucit = findViewById(R.id.fscTotalAku);

        showResultPucit = findViewById(R.id.showResultPucit);

        calculatePucit = findViewById(R.id.calculatePucit);

        meritSearch = findViewById(R.id.searchWindowOpen);

        calculatePucit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double fscObtainPu = Double.parseDouble(fscPucit.getText().toString());
                    double fscTotalMarksPu = Double.parseDouble(fscTotalPucit.getText().toString());
                    double percentageFscPu = (fscObtainPu / fscTotalMarksPu) * 100;
                    double formulaFscPu = percentageFscPu * (80.0 / 100.0);
                    if (fscObtainPu <= fscTotalMarksPu && fscTotalMarksPu <= 2000){
                        fscVerification = true;
                    }
                    double matMarksPu = Double.parseDouble(matricPucit.getText().toString());
                    double matMarksTotalPu = Double.parseDouble(matricTotalPucit.getText().toString());
                    double percentageMatPu = (matMarksPu / matMarksTotalPu) * 100;
                    double formulaMatPu = percentageMatPu * (20.0 / 100.0);
                    if (matMarksPu <= matMarksTotalPu && matMarksTotalPu <= 2000){
                        matricVerification = true;
                    }
                    double endResult = formulaFscPu + formulaMatPu;
                    if (fscVerification && matricVerification) {
                        showResultPucit.setText("Your aggregate is " + endResult + "%");
                    }
                    else{
                        showResultPucit.setText(" ");
                        Toast.makeText(PucitMeritCalculator.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e){
                    Toast.makeText(PucitMeritCalculator.this, "Enter valid inputs.", Toast.LENGTH_SHORT).show();
                }
                matricVerification = false;
                fscVerification = false;
            }
        });
    }

    public void windowSearchPu(View v){
        Intent intent = new Intent(this, PucitMeritSearch.class);
        startActivity(intent);
    }
}