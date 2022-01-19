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

public class UetMeritSearch extends AppCompatActivity {
    EditText yearUet;
    EditText degreeUet;
    Button searchUet;
    TextView displayUet;
    int iteratorYears = 0;
    int iteratorDegrees = 0;
    int indexDegrees = 0;
    int indexYears = 0;

    String yearFetch = "";
    String degreeFetch = "";

    public String[] yearsArrayUet;
    public String[] degreeArrayUet;
    public String[][] meritArrayUet = {{"74.08%","73.10%","72.08%","73.05%","73.92%","73.33%","72.47%","71.88%"}, {"80.35%","82.23%","76.86%","78.10%","74.80%","77.83%","79.03%","NIL"}, {"75.65%","77.69%","72.97%","73.67%","71.91%","73.36%","74.80%","NIL"}, {"78.83%","76.0%","74.97%","76.93%","72.04%","75.07%","74.39%","NIL"},{"77.12%","74.74%","73.02%","75.20%","70.05%","74.47%","73.20%","NIL"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uet_merit_search);

        yearUet = findViewById(R.id.yearUet);
        degreeUet = findViewById(R.id.degreeUet);
        displayUet = findViewById(R.id.displayUet);
        searchUet = findViewById(R.id.searchUet);

        searchUet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // year
                try{
                    DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("sessionUet.txt")));
                    Scanner sc = new Scanner(mainStream);
                    while (sc.hasNextLine()){
                        yearFetch = sc.nextLine();
                    }
                    yearsArrayUet = yearFetch.split(",");
                    sc.close();
                }
                catch (IOException e){
                    Toast.makeText(UetMeritSearch.this, "Can't find anything.", Toast.LENGTH_SHORT).show();
                }


                // Degree
                try {
                    DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("degreeUet.txt")));
                    Scanner sc = new Scanner(mainStream);
                    while (sc.hasNextLine()){
                        degreeFetch = sc.nextLine();
                    }
                    degreeArrayUet = degreeFetch.split(",");
                    sc.close();
                }
                catch (IOException e){
                    Toast.makeText(UetMeritSearch.this, "Can't find anything.", Toast.LENGTH_SHORT).show();
                }

                // Main Algorithm
                try {
                    for (int i = 0; i < yearsArrayUet.length; i++) {

                        if (yearUet.getText().toString().equals(yearsArrayUet[i])) {
                            indexYears = i;
                            break;
                        }
                        iteratorYears++;
                    }

                    for (int j = 0; j < degreeArrayUet.length; j++){

                        if (degreeArrayUet[j].contains(degreeUet.getText().toString().toUpperCase())){
                            indexDegrees = j;
                            break;
                        }
                        iteratorDegrees++;
                    }

                    if (iteratorDegrees < degreeArrayUet.length - 1 && iteratorYears < yearsArrayUet.length - 1) {
                        displayUet.setText("For the year " + yearsArrayUet[indexYears] + " last merit for " + degreeArrayUet[indexDegrees] + " was " + meritArrayUet[indexYears][indexDegrees]);
                        iteratorDegrees = 0;
                        iteratorYears = 0;
                    }
                    else{
                        displayUet.setText("Can't find anything. Try entering valid numeric inputs.");
                        iteratorDegrees = 0;
                        iteratorYears = 0;
                    }
                }
                catch (Exception e){
                    Toast.makeText(UetMeritSearch.this, "Couldn't find anything", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}