package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.*;
import java.util.*;
import java.io.*;


public class EngineeringSuggestion extends AppCompatActivity {
    EditText matricEngSug;
    EditText matricTotalEngSug;
    EditText fscEngSug;
    EditText fscTotalEngSug;
    EditText mathsEngSug;
    EditText physicsEngSug;
    EditText chemistryEngSug;
    Button fieldEngSug;
    TextView displayEngSug;

    // X - axis evaluation
    double evaluationMatric = 0.0;
    double evaluationFsc = 0.0;
    double x_value = 0.0;

    // Y - axis evaluation
    double mathEval = 0.0;
    double phyEval = 0.0;
    double chemEval = 0.0;
    double y_value = 0.0;
    boolean checkVal = false;

    // Arrays
    public String[] datasetXaxisMechanical = new String[50];
    public String[] datasetXaxisElectrical = new String[50];
    public String[] datasetXaxisMetallurgy = new String[50];
    public String[] datasetXaxisCivil = new String[50];

    public String[] datasetYaxisMechanical = new String[50];
    public String[] datasetYaxisElectrical = new String[50];
    public String[] datasetYaxisMetallurgy = new String[50];
    public String[] datasetYaxisCivil = new String[50];

    // Fetching strings
    String dataXMechanical = "";
    String dataXElectrical = "";
    String dataXMetallurgy = "";
    String dataXCivil = "";

    String dataYMehcanical = "";
    String dataYElectrical = "";
    String dataYCivil = "";
    String dataYMetallurgy = "";

    int k = 7;

    // means
    public double[] distanceMechanical = new double[50];
    public double[] distanceElectrical = new double[50];
    public double[] distanceMetallurgy = new double[50];
    public double[] distanceCivil = new double[50];

    double meanDistanceMechanical = 0.0;
    double meanDistanceElectrical = 0.0;
    double meanDistanceCivil = 0.0;
    double meanDistanceMetallurgy = 0.0;

    public double[] distances = new double[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineering_suggestion);
        matricEngSug = findViewById(R.id.matricEngineeringSuggestion);
        matricTotalEngSug = findViewById(R.id.matricTotalAku);
        fscEngSug = findViewById(R.id.fscAku);
        fscTotalEngSug = findViewById(R.id.fscTotalAku);
        mathsEngSug = findViewById(R.id.testAku);
        physicsEngSug = findViewById(R.id.testTotalAku);
        chemistryEngSug = findViewById(R.id.chemEngSug);
        fieldEngSug = findViewById(R.id.fieldEngSug);
        displayEngSug = findViewById(R.id.displayEngSug);

        fieldEngSug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // fsc and matric

                try {
                    double fsc = Double.parseDouble(fscEngSug.getText().toString());
                    double fscTotal = Double.parseDouble(fscTotalEngSug.getText().toString());
                    double percentageFsc = (fsc/fscTotal) * 100;
                    evaluationFsc = percentageFsc * (50.0/100.0);

                    double mat = Double.parseDouble(matricEngSug.getText().toString());
                    double matTotal = Double.parseDouble(matricTotalEngSug.getText().toString());
                    double percentageMat = (mat/matTotal) * 100;
                    evaluationMatric = percentageMat * (50.0/100.0);

                    x_value = evaluationFsc+evaluationMatric;
                    //System.out.println(total);

                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(EngineeringSuggestion.this, "Enter valid input", Toast.LENGTH_SHORT).show();
                }

                try{
                    double math = Double.parseDouble(mathsEngSug.getText().toString());
                    double phy = Double.parseDouble(physicsEngSug.getText().toString());
                    double chem = Double.parseDouble(chemistryEngSug.getText().toString());
                    if ((math <= 10 || math >= 0) && (phy <= 10 || phy >= 0) && (chem <= 10 || chem >= 0)) {
                        displayEngSug.setText("");
                        double mathperc = (math / 10) * 100;
                        mathEval = mathperc * (33.33 / 100.0);

                        double phyperc = (phy/10) * 100;
                        phyEval = phyperc * (33.33/100.0);


                        double chemperc = (chem/10) * 100;
                        chemEval = chemperc * (33.33/100.0);

                        y_value = mathEval+phyEval+chemEval;
                        checkVal = true;
                    }
                    else if (!((math <= 10 && math >= 0) && (phy <= 10 && phy >= 0) && (chem <= 10 && chem >= 0))){
                        Toast.makeText(EngineeringSuggestion.this, "Enter valid input between 0 and 10", Toast.LENGTH_SHORT).show();
                        checkVal = false;
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(EngineeringSuggestion.this, "Can't find anything 1", Toast.LENGTH_SHORT).show();
                }

                if (checkVal) {
                    // datasets X-axis
                    try {
                        DataInputStream mainstream = new DataInputStream(getAssets().open(String.format("datasetXaxisNumbersMechanical.txt")));
                        Scanner sc = new Scanner(mainstream);
                        while (sc.hasNextLine()) {
                            dataXMechanical = sc.nextLine();
                        }
                        datasetXaxisMechanical = dataXMechanical.split(",");
                    } catch (IOException e) {
                        Toast.makeText(EngineeringSuggestion.this, "An error occurred 1", Toast.LENGTH_SHORT).show();
                    }

                    try {
                        DataInputStream mainstream = new DataInputStream(getAssets().open(String.format("datasetXaxisNumbersElectrical.txt")));
                        Scanner sc = new Scanner(mainstream);
                        while (sc.hasNextLine()) {
                            dataXElectrical = sc.nextLine();
                        }
                        datasetXaxisElectrical = dataXElectrical.split(",");
                    } catch (IOException e) {
                        Toast.makeText(EngineeringSuggestion.this, "An error occurred 2", Toast.LENGTH_SHORT).show();
                    }

                    try {
                        DataInputStream mainstream = new DataInputStream(getAssets().open(String.format("datasetXaxisNumbersMetallurgy.txt")));
                        Scanner sc = new Scanner(mainstream);
                        while (sc.hasNextLine()) {
                            dataXMetallurgy = sc.nextLine();
                        }
                        datasetXaxisMetallurgy = dataXMetallurgy.split(",");
                    } catch (IOException e) {
                        Toast.makeText(EngineeringSuggestion.this, "An error occurred 3", Toast.LENGTH_SHORT).show();
                    }

                    try {
                        DataInputStream mainstream = new DataInputStream(getAssets().open(String.format("datasetXaxisNumbersCivil.txt")));
                        Scanner sc = new Scanner(mainstream);
                        while (sc.hasNextLine()) {
                            dataXCivil = sc.nextLine();
                        }
                        datasetXaxisCivil = dataXCivil.split(",");
                    } catch (IOException e) {
                        Toast.makeText(EngineeringSuggestion.this, "An error occurred 4", Toast.LENGTH_SHORT).show();
                    }


                    // datasets y-axis
                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetYaxisInterestMechanical.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataYMehcanical = sc.nextLine();
                        }
                        datasetYaxisMechanical = dataYMehcanical.split(",");
                    } catch (IOException e) {
                        Toast.makeText(EngineeringSuggestion.this, "An error occured 5", Toast.LENGTH_SHORT).show();
                    }

                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetYaxisInterestElectrical.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataYElectrical = sc.nextLine();
                        }
                        datasetYaxisElectrical = dataYElectrical.split(",");
                    } catch (IOException e) {
                        Toast.makeText(EngineeringSuggestion.this, "An error occured 6", Toast.LENGTH_SHORT).show();
                    }


                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetYaxisInterestCivil.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataYCivil = sc.nextLine();
                        }
                        datasetYaxisCivil = dataYCivil.split(",");
                    } catch (IOException e) {
                        Toast.makeText(EngineeringSuggestion.this, "An error occured 7", Toast.LENGTH_SHORT).show();
                    }


                    try {
                        DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("datasetYaxisInterestMetallurgy.txt")));
                        Scanner sc = new Scanner(mainStream);
                        while (sc.hasNextLine()) {
                            dataYMetallurgy = sc.nextLine();
                        }
                        datasetYaxisMetallurgy = dataYMetallurgy.split(",");
                    } catch (IOException e) {
                        Toast.makeText(EngineeringSuggestion.this, "An error occured 8", Toast.LENGTH_SHORT).show();
                    }


                    // Main algorithm
                    try {

                        // calculating distances
                        for (int i = 0; i < datasetXaxisMechanical.length; i++) {
                            // Mechanical
                            double distanceCalculateMechanical = Math.sqrt(((Double.parseDouble(datasetXaxisMechanical[i]) - x_value) * (Double.parseDouble(datasetXaxisMechanical[i]) - x_value)) + ((Double.parseDouble(datasetYaxisMechanical[i]) - y_value) * (Double.parseDouble(datasetYaxisMechanical[i]) - y_value)));
                            distanceMechanical[i] = distanceCalculateMechanical;

                            // Electrical
                            double distanceCalculateElectrical = Math.sqrt(((Double.parseDouble(datasetXaxisElectrical[i]) - x_value) * (Double.parseDouble(datasetXaxisElectrical[i]) - x_value)) + ((Double.parseDouble(datasetYaxisElectrical[i]) - y_value) * (Double.parseDouble(datasetYaxisElectrical[i]) - y_value)));
                            distanceElectrical[i] = distanceCalculateElectrical;

                            // Civil
                            double distanceCalculateCivil = Math.sqrt(((Double.parseDouble(datasetXaxisCivil[i]) - x_value) * (Double.parseDouble(datasetXaxisCivil[i]) - x_value)) + ((Double.parseDouble(datasetYaxisCivil[i]) - y_value) * (Double.parseDouble(datasetYaxisCivil[i]) - y_value)));
                            distanceCivil[i] = distanceCalculateCivil;

                            // Metallurgy
                            double distanceCalculateMetallurgy = Math.sqrt(((Double.parseDouble(datasetXaxisMetallurgy[i]) - x_value) * (Double.parseDouble(datasetXaxisMetallurgy[i]) - x_value)) + ((Double.parseDouble(datasetYaxisMetallurgy[i]) - y_value) * (Double.parseDouble(datasetYaxisMetallurgy[i]) - y_value)));
                            distanceMetallurgy[i] = distanceCalculateMetallurgy;
                        }

                        // sorting arrays
                        for (int i = 0; i < distanceMetallurgy.length; i++) {
                            for (int j = i + 1; j < distanceMetallurgy.length; j++) {
                                // mechanical distance sort
                                if (distanceMechanical[j] < distanceMechanical[i]) {
                                    double temp = distanceMechanical[i];
                                    distanceMechanical[i] = distanceMechanical[j];
                                    distanceMechanical[j] = temp;
                                }

                                // metallurgy distance sort
                                if (distanceMetallurgy[j] < distanceMetallurgy[i]) {
                                    double temp = distanceMetallurgy[i];
                                    distanceMetallurgy[i] = distanceMetallurgy[j];
                                    distanceMetallurgy[j] = temp;
                                }

                                // Electrical distance sort
                                if (distanceElectrical[j] < distanceElectrical[i]) {
                                    double temp = distanceElectrical[i];
                                    distanceElectrical[i] = distanceElectrical[j];
                                    distanceElectrical[j] = temp;
                                }

                                // Civil distance sort
                                if (distanceCivil[j] < distanceCivil[i]) {
                                    double temp = distanceCivil[i];
                                    distanceCivil[i] = distanceCivil[j];
                                    distanceCivil[j] = temp;
                                }

                            }
                        }

                    } catch (Exception e) {
                        Toast.makeText(EngineeringSuggestion.this, "An error occurred 9", Toast.LENGTH_SHORT).show();
                    }

                    for (int i = 0; i < k; i++) {
                        meanDistanceMechanical += distanceMechanical[i];
                        meanDistanceCivil += distanceCivil[i];
                        meanDistanceMetallurgy += distanceMetallurgy[i];
                        meanDistanceElectrical += distanceElectrical[i];
                    }

                    distances[0] = meanDistanceElectrical;
                    distances[1] = meanDistanceMetallurgy;
                    distances[2] = meanDistanceCivil;
                    distances[3] = meanDistanceMechanical;

                    for (int x = 0; x < distances.length; x++) {
                        for (int z = x + 1; z < distances.length; z++) {
                            if (distances[z] < distances[x]) {
                                double temp = distances[x];
                                distances[x] = distances[z];
                                distances[z] = temp;
                            }
                        }
                    }

                    if (distances[0] == meanDistanceMechanical) {
                        displayEngSug.setText("Our suggestion for you is Mechanical Engineering. Top universities for Mechanical Engineering are\n1. NUST\n2. PIEAS\n3. GIKI");
                    } else if (distances[0] == meanDistanceElectrical) {
                        displayEngSug.setText("Our suggestion for you is Electrical Engineering. Top universities for Electrical Engineering are\n1. NUST\n2. GIKI\n3. UET Lahore");
                    } else if (distances[0] == meanDistanceMetallurgy) {
                        displayEngSug.setText("Our suggestion for you Metallurgy and Atomic Engineering. Top Universities for Metallurgy and atomic engineering are\n1. PIEAS");
                    } else if (distances[0] == meanDistanceCivil) {
                        displayEngSug.setText("Our suggestion for you is Civil Engineering. Top universities for Civil Engineering are\n1. NUST\n2. UET Lahore");
                    }
                }
                x_value = 0;
                y_value = 0;
                mathEval = 0.0;
                phyEval = 0.0;
                chemEval = 0.0;
                checkVal = false;
                evaluationFsc = 0.0;
                evaluationMatric = 0.0;
            }
        });
        // Resetting parameters and features


    }
}