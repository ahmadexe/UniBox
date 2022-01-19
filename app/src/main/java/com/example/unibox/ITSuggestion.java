package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.util.*;
import java.lang.*;

public class ITSuggestion extends AppCompatActivity {
    EditText matItSug;
    EditText matTotalItSug;
    EditText fscItSug;
    EditText fscTotalItSug;
    EditText mathItSug;
    EditText psItSug;

    Button findItSug;
    TextView displayItSug;

    // X - axis evaluation
    double evaluationMatric = 0.0;
    double evaluationFsc = 0.0;
    double x_value = 0.0;

    // Y - axis evaluation
    double mathEval = 0.0;
    double psEval = 0.0;
    double y_value = 0.0;
    double y_valueDS = 0.0;

    // boolean
    boolean checkVal = false;

    // Arrays
    public String[] datasetXaxisCS = new String[50];
    public String[] datasetXaxisSE = new String[50];
    public String[] datasetXaxisAI = new String[50];
    public String[] datasetXaxisDS = new String[50];
    public String[] datasetXaxisCT = new String[50];


    public String[] datasetYaxisCS = new String[50];
    public String[] datasetYaxisSE = new String[50];
    public String[] datasetYaxisAI = new String[50];
    public String[] datasetYaxisDS = new String[50];
    public String[] datasetYaxisCT = new String[50];


    // Fetching strings
    String dataXCS = "";
    String dataXSE = "";
    String dataXAI = "";
    String dataXDS = "";
    String dataXCT = "";

    String dataYCS = "";
    String dataYSE = "";
    String dataYAI = "";
    String dataYDS = "";
    String dataYCT = "";

    // Neighbour value
    int k = 7;

    // means
    public double[] distanceCS = new double[50];
    public double[] distanceSE = new double[50];
    public double[] distanceAI = new double[50];
    public double[] distanceDS = new double[50];
    public double[] distanceCT = new double[50];

    double meanDistanceCS = 0.0;
    double meanDistanceSE = 0.0;
    double meanDistanceAI = 0.0;
    double meanDistanceDS = 0.0;
    double meanDistanceCT = 0.0;


    public double[] distances = new double[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itsuggestion);
        matItSug = findViewById(R.id.matricEngineeringSuggestion);
        matTotalItSug = findViewById(R.id.matricTotalAku);
        fscItSug = findViewById(R.id.fscAku);
        fscTotalItSug = findViewById(R.id.fscTotalAku);
        mathItSug = findViewById(R.id.testAku);
        psItSug = findViewById(R.id.testTotalAku);

        findItSug = findViewById(R.id.findItSug);
        displayItSug = findViewById(R.id.displayItSug);

        findItSug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    double fsc = Double.parseDouble(fscItSug.getText().toString());
                    double fscTotal = Double.parseDouble(fscTotalItSug.getText().toString());
                    double percentageFsc = (fsc/fscTotal) * 100;
                    evaluationFsc = percentageFsc * (50.0/100.0);

                    double mat = Double.parseDouble(matItSug.getText().toString());
                    double matTotal = Double.parseDouble(matTotalItSug.getText().toString());
                    double percentageMat = (mat/matTotal) * 100;
                    evaluationMatric = percentageMat * (50.0/100.0);

                    x_value = evaluationFsc+evaluationMatric;
                    //System.out.println(total);

                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(ITSuggestion.this, "Enter valid input", Toast.LENGTH_SHORT).show();
                }


                // Y axis
                try{
                    double math = Double.parseDouble(mathItSug.getText().toString());
                    double ps = Double.parseDouble(psItSug.getText().toString());

                    if ((math <= 10 || math >= 0) && (ps <= 10 || ps >= 0)) {
                        displayItSug.setText("");
                        double mathperc = (math / 10) * 100;
                        mathEval = mathperc * (50.00 / 100.0);
                        double mathevalDS = mathperc * (95.00 / 100.00);

                        double phyperc = (ps/10) * 100;
                        psEval = phyperc * (50.00/100.0);
                        double physicsEvalDS = phyperc * (5.00 / 100.0);
                        y_valueDS = mathevalDS + physicsEvalDS;
                        y_value = mathEval+psEval;
                        checkVal = true;
                    }
                    else if (!((math <= 10 && math >= 0) && (ps <= 10 && ps >= 0))){
                        Toast.makeText(ITSuggestion.this, "Enter valid input between 0 and 10", Toast.LENGTH_SHORT).show();
                        checkVal = false;
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(ITSuggestion.this, "Can't find anything 1", Toast.LENGTH_SHORT).show();
                }

                if (checkVal) {
                    // Generating X axis datasets
                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetXaxisCS.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataXCS = sc.nextLine();
                        }
                        datasetXaxisCS = dataXCS.split(",");
                    } catch (IOException e) {
                        Toast.makeText(ITSuggestion.this, "Can't get anything", Toast.LENGTH_SHORT).show();
                    }


                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetXaxisSE.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataXSE = sc.nextLine();
                        }
                        datasetXaxisSE = dataXSE.split(",");
                    } catch (IOException e) {
                        Toast.makeText(ITSuggestion.this, "Can't get anything", Toast.LENGTH_SHORT).show();
                    }

                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetXaxisAI.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataXAI = sc.nextLine();
                        }
                        datasetXaxisAI = dataXAI.split(",");
                    } catch (IOException e) {
                        Toast.makeText(ITSuggestion.this, "Can't get anything", Toast.LENGTH_SHORT).show();
                    }


                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetXaxisDS.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataXDS = sc.nextLine();
                        }
                        datasetXaxisDS = dataXDS.split(",");
                    } catch (IOException e) {
                        Toast.makeText(ITSuggestion.this, "Can't get anything", Toast.LENGTH_SHORT).show();
                    }


                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetXaxisCT.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataXCT = sc.nextLine();
                        }
                        datasetXaxisCT = dataXCT.split(",");
                    } catch (IOException e) {
                        Toast.makeText(ITSuggestion.this, "Can't get anything", Toast.LENGTH_SHORT).show();
                    }

                    // Y axis dataset generation

                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetYaxisCS.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataYCS = sc.nextLine();
                        }
                        datasetYaxisCS = dataYCS.split(",");
                    } catch (IOException e) {
                        Toast.makeText(ITSuggestion.this, "Can't find anything", Toast.LENGTH_SHORT).show();
                    }

                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetYaxisSE.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataYSE = sc.nextLine();
                        }
                        datasetYaxisSE = dataYSE.split(",");
                    } catch (IOException e) {
                        Toast.makeText(ITSuggestion.this, "Can't find anything", Toast.LENGTH_SHORT).show();
                    }


                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetYaxisAI.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataYAI = sc.nextLine();
                        }
                        datasetYaxisAI = dataYAI.split(",");
                    } catch (IOException e) {
                        Toast.makeText(ITSuggestion.this, "Can't find anything", Toast.LENGTH_SHORT).show();
                    }

                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetYaxisDS.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataYDS = sc.nextLine();
                        }
                        datasetYaxisDS = dataYDS.split(",");
                    } catch (IOException e) {
                        Toast.makeText(ITSuggestion.this, "Can't find anything", Toast.LENGTH_SHORT).show();
                    }

                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetYaxisCT.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataYCT = sc.nextLine();
                        }
                        datasetYaxisCT = dataYCT.split(",");
                    } catch (IOException e) {
                        Toast.makeText(ITSuggestion.this, "Can't find anything", Toast.LENGTH_SHORT).show();
                    }


                    // Main Algorithm K - Nearest Neighbour
                    for (int i = 0; i < datasetXaxisCS.length; i++) {
                        // CS
                        double distanceCalcCS = Math.sqrt(((Double.parseDouble(datasetXaxisCS[i]) - x_value) * (Double.parseDouble(datasetXaxisCS[i]) - x_value)) + ((Double.parseDouble(datasetYaxisCS[i]) - y_value) * (Double.parseDouble(datasetYaxisCS[i]) - y_value)));
                        distanceCS[i] = distanceCalcCS;

                        // SE
                        double distanceCalcSE = Math.sqrt(((Double.parseDouble(datasetXaxisSE[i]) - x_value) * (Double.parseDouble(datasetXaxisSE[i]) - x_value)) + ((Double.parseDouble(datasetYaxisSE[i]) - y_value) * (Double.parseDouble(datasetYaxisSE[i]) - y_value)));
                        distanceSE[i] = distanceCalcSE;


                        //AI
                        double distanceCalcAI = Math.sqrt(((Double.parseDouble(datasetXaxisAI[i]) - x_value) * (Double.parseDouble(datasetXaxisAI[i]) - x_value)) + ((Double.parseDouble(datasetYaxisAI[i]) - y_value) * (Double.parseDouble(datasetYaxisAI[i]) - y_value)));
                        distanceAI[i] = distanceCalcAI;


                        // DS
                        double distanceCalcDS = Math.sqrt(((Double.parseDouble(datasetXaxisDS[i]) - x_value) * (Double.parseDouble(datasetXaxisDS[i]) - x_value)) + ((Double.parseDouble(datasetYaxisDS[i]) - y_valueDS) * (Double.parseDouble(datasetYaxisDS[i]) - y_valueDS)));
                        distanceDS[i] = distanceCalcDS;

                        // Cyber security
                        double distanceCalcCT = Math.sqrt(((Double.parseDouble(datasetXaxisCT[i]) - x_value) * (Double.parseDouble(datasetXaxisCT[i]) - x_value)) + ((Double.parseDouble(datasetYaxisCT[i]) - y_value) * (Double.parseDouble(datasetYaxisCT[i]) - y_value)));
                        distanceCT[i] = distanceCalcCT;

                    }

                    // Sorting algorithm
                    for (int i = 0; i < distanceCS.length; i++) {
                        for (int j = i + 1; j < distanceCS.length; j++) {
                            // CS
                            if (distanceCS[j] < distanceCS[i]) {
                                double temp = distanceCS[i];
                                distanceCS[i] = distanceCS[j];
                                distanceCS[j] = temp;

                            }

                            // SE
                            if (distanceSE[j] < distanceSE[i]) {
                                double temp = distanceSE[i];
                                distanceSE[i] = distanceSE[j];
                                distanceSE[j] = temp;

                            }

                            // AI
                            if (distanceAI[j] < distanceAI[i]) {
                                double temp = distanceAI[i];
                                distanceAI[i] = distanceAI[j];
                                distanceAI[j] = temp;

                            }


                            //  DS
                            if (distanceDS[j] < distanceDS[i]) {
                                double temp = distanceDS[i];
                                distanceDS[i] = distanceDS[j];
                                distanceDS[j] = temp;

                            }

                            // Cyber security
                            if (distanceCT[j] < distanceCT[i]) {
                                double temp = distanceCT[i];
                                distanceCT[i] = distanceCT[j];
                                distanceCT[j] = temp;

                            }
                        }
                    }

                    for (int i = 0; i < k; i++) {
                        meanDistanceCS += distanceCS[i];
                        meanDistanceSE += distanceSE[i];
                        meanDistanceAI += distanceAI[i];
                        meanDistanceDS += distanceDS[i];
                        meanDistanceCT += distanceCT[i];
                    }

                    distances[0] = meanDistanceCS;
                    distances[1] = meanDistanceSE;
                    distances[2] = meanDistanceAI;
                    distances[3] = meanDistanceDS;
                    distances[4] = meanDistanceCT;

                    for (int i = 0; i < distances.length; i++) {
                        for (int j = i + 1; j < distances.length; j++) {
                            if (distances[j] < distances[i]) {
                                double temp = distances[i];
                                distances[i] = distances[j];
                                distances[j] = temp;
                            }
                        }
                    }

                    if (distances[0] == meanDistanceCS) {
                        displayItSug.setText("Our suggestion for you is Computer Science. Top universities for Computer Science are\n1. COMSATS ISB.\n2. FAST-NUCES.\n3. NUST.");
                    } else if (distances[0] == meanDistanceSE) {
                        displayItSug.setText("Our suggestion for you is Software Engineering. Top universities for Software Engineering are\n1. NUST.\n2. COMSATS ISB.\n3. PUCIT.");
                    } else if (distances[0] == meanDistanceAI) {
                        displayItSug.setText("Our suggestion for you is Artificial Intelligence. Top Universities for Artificial Intelligence are\n1. FAST-NUCES.\n2. COMSATS ISB.");
                    } else if (distances[0] == meanDistanceDS) {
                        displayItSug.setText("Our suggestion for you is Data Science. Top universities for Data Science are\n1. COMSATS ISB.");
                    } else if (distances[0] == meanDistanceCT) {
                        displayItSug.setText("Our suggestion for you is Cyber Security. Top universities for Cyber Security are\n1. COMSATS ISB.");
                    }
                }

                else {
                    Toast.makeText(ITSuggestion.this, "Enter valid inputs from 0 - 10", Toast.LENGTH_SHORT).show();
                }

                x_value = 0.0;
                y_value = 0.0;
                mathEval = 0.0;
                psEval = 0.0;
                evaluationMatric = 0.0;
                evaluationFsc = 0.0;
                checkVal = false;

            }

        });
    }
}