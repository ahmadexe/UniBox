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


public class PucitMeritSearch extends AppCompatActivity {

    EditText yearPucit;
    EditText degreePucit;
    TextView displayPucit;
    Button searchPucit;

    String yearsFetch = "";
    String degreeFetch = "";
    int iteratorYears = 0;
    int iteratorDegrees = 0;
    int indexDegrees = 0;
    int indexYears = 0;
    public String[] yearsArrayPu;
    public String[] degreeArrayPu;
    public String[][] meritArrayPu = {{"101.50%","101.32%","99.2%","97.5%","94.33%","NIL"},{"84.69%","83.49%","83.79%","81.47%","82.45%","NIL"},{"86.43%","85.23%","NIL","NIL","NIL","81.25%"},{"82.68%","84.31%","NIL","NIL","NIL","NIL"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pucit_merit_search);
        yearPucit = findViewById(R.id.yearPucit);
        degreePucit = findViewById(R.id.degreePucit);
        displayPucit = findViewById(R.id.displayPucit);
        searchPucit = findViewById(R.id.searchPucit);


        searchPucit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format("sessionPucit.txt")));
                    Scanner sc = new Scanner(textFileStream);
                    while (sc.hasNextLine()) {
                        yearsFetch = sc.nextLine();
                    }
                    yearsArrayPu = yearsFetch.split(",");
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                // Degree
                try {
                    DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format("degreePucit.txt")));
                    Scanner sc = new Scanner(textFileStream);
                    while (sc.hasNextLine()) {
                        degreeFetch = sc.nextLine();
                    }
                    degreeArrayPu = degreeFetch.split(",");
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                // Main algorithm to find merits.

                try {
                    for (int i = 0; i < yearsArrayPu.length; i++) {

                        if (yearPucit.getText().toString().toUpperCase().equals(yearsArrayPu[i])) {
                            indexYears = i;
                            break;
                        }
                        iteratorYears++;
                    }

                    for (int j = 0; j < degreeArrayPu.length; j++){

                        if (degreeArrayPu[j].contains(degreePucit.getText().toString().toUpperCase())){
                            indexDegrees = j;
                            break;
                        }
                        iteratorDegrees++;
                    }

                    if (iteratorDegrees < degreeArrayPu.length - 1 && iteratorYears < yearsArrayPu.length - 1) {
                        displayPucit.setText("For the session " + yearsArrayPu[indexYears] + " last merit for " + degreeArrayPu[indexDegrees] + " was " + meritArrayPu[indexYears][indexDegrees]);
                        iteratorYears = 0;
                        iteratorDegrees = 0;
                    }
                    else{
                        displayPucit.setText("Can't find anything. Try entering valid numeric inputs.");
                        iteratorYears = 0;
                        iteratorDegrees = 0;
                    }
                }
                catch (Exception e){
                    Toast.makeText(PucitMeritSearch.this, "Couldn't find anything", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}