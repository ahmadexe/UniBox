package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;
import java.io.*;
import java.lang.*;

public class MedicalSuggestion<Final> extends AppCompatActivity {

    EditText fscMedicalSuggestion;
    EditText matricMedicalSuggestion;
    Button fieldMedical;
    TextView displayFieldMedical;

    double formulaFsc = 0.0;
    double formulaMatric = 0.0;
    double total = 0.0;

    public String[] datasetMbbs = new String[50];
    public String[] datasetBds = new String[50];

    String dataMbbs = "";
    String dataBds = "";
    
    public double[] distanceMbbs = new double[50];
    public double[] distanceBds = new double[50];

    double sumMbbsSquaredDistance = 0;
    double sumBdsSquaredDistance = 0;

    int k = 7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_suggestion);
        fscMedicalSuggestion = findViewById(R.id.fscMedicalSuggestion);
        matricMedicalSuggestion = findViewById(R.id.matricMedicalSuggestion);
        displayFieldMedical = findViewById(R.id.displayFieldMedical);
        fieldMedical = findViewById(R.id.fieldMedical);

        fieldMedical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // fsc and matric

                try {
                      double fsc = Double.parseDouble(fscMedicalSuggestion.getText().toString());
                      double percentageFsc = (fsc/1100.0) * 100;
                      formulaFsc = percentageFsc * (70.0/100.0);

                      double mat = Double.parseDouble(matricMedicalSuggestion.getText().toString());
                      double percentageMat = (mat/1100.0) * 100;
                      formulaMatric = percentageMat * (30.0/100.0);

                      total = formulaFsc+formulaMatric;
                      //System.out.println(total);

                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MedicalSuggestion.this, "Enter valid input", Toast.LENGTH_SHORT).show();
                }

                // MBBS dataset

                try {
                    DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetMbbs.txt")));
                    Scanner sc = new Scanner(mainStream);
                    while (sc.hasNextLine()){
                        dataMbbs = sc.nextLine();
                    }
                    datasetMbbs = dataMbbs.split(",");

                }
                catch (IOException e){
                    Toast.makeText(MedicalSuggestion.this, "An error occured at mbbs", Toast.LENGTH_SHORT).show();
                }

                // BDS dataset

                try {
                    DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetBds.txt")));
                    Scanner sc = new Scanner(mainStream);
                    while (sc.hasNextLine()){
                        dataBds = sc.nextLine();
                    }
                    datasetBds = dataBds.split(",");

                }
                catch (IOException e){
                    Toast.makeText(MedicalSuggestion.this, "An error occured bds", Toast.LENGTH_SHORT).show();
                }

                // Main algorithm
                // for mbbs data set
                try {
                    for (int i = 0; i < datasetMbbs.length; i++) {
                        double distance = Double.parseDouble(datasetMbbs[i]) - total;
                        double squaredDistance = distance * distance;
                        distanceMbbs[i] = squaredDistance;
                    }
                    // for bds data set
                    for (int i = 0; i < datasetBds.length; i++) {
                        double distance = Double.parseDouble(datasetBds[i]) - total;
                        double squaredDistance = distance * distance;
                        distanceBds[i] = squaredDistance;
                    }

                    // sorting arrays
                    for (int i = 0; i < distanceMbbs.length; i++){
                        for (int j = i+1; j < distanceMbbs.length; j++){
                            // sorting mbbs array
                            if (distanceMbbs[j]<distanceMbbs[i]){
                                double temp = distanceMbbs[i];
                                distanceMbbs[i] = distanceMbbs[j];
                                distanceMbbs[j] = temp;
                            }
                            // sorting bds array
                            if (distanceBds[j]<distanceBds[i]){
                                double temp = distanceBds[i];
                                distanceBds[i] = distanceBds[j];
                                distanceBds[j] = temp;
                            }

                        }
                    }

                    for (int i = 0; i < k; i++){
                        sumMbbsSquaredDistance += distanceMbbs[i];
                        sumBdsSquaredDistance += distanceBds[i];
                    }
                    double meanSquaredDistanceMbbs = sumMbbsSquaredDistance/k;
                    double meanSquaredDistanceBds = sumBdsSquaredDistance/k;

                    if (meanSquaredDistanceMbbs <= meanSquaredDistanceBds){
                        displayFieldMedical.setText("Our suggestion for you is MBBS.");
                    }
                    else{
                        displayFieldMedical.setText("Our suggestion for you is BDS");
                    }

                }
                catch (Exception e){
                    Toast.makeText(MedicalSuggestion.this, "An error occured at final", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        // Resetting parameters
        formulaFsc = 0.0;
        formulaMatric = 0.0;
        total = 0.0;
    }
}