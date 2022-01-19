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

public class FastMeritSearch extends AppCompatActivity {
    Button searchFast;
    TextView displayFast;

    EditText yearFast;
    EditText degreeFast;

    int iteratorYears = 0;
    int iteratorDegrees = 0;
    int indexDegrees = 0;
    int indexYears = 0;

    String yearsFetch = "";
    String degreeFetch = "";

    public String[] yearsArrayFast;
    public String[] degreeArrayFast;
    public String[][] meritArrayFast = {{"84.50%","83.32%","83.12%","82.01%","82.33%","81.88%"},{"84.69%","83.49%","83.79%","81.47%","82.45%","NIL"},{"86.43%","85.23%","NIL","NIL","NIL","81.25%"},{"82.68%","84.31%","NIL","NIL","NIL","NIL"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_merit_search);
        searchFast = findViewById(R.id.searchFast);
        displayFast = findViewById(R.id.displayFast);
        yearFast = findViewById(R.id.yearFast);
        degreeFast = findViewById(R.id.degreeFast);


        searchFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // years

                try {
                    DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format("sessionFast.txt")));
                    Scanner sc = new Scanner(textFileStream);
                    while (sc.hasNextLine()) {
                        yearsFetch = sc.nextLine();
                    }
                    yearsArrayFast = yearsFetch.split(",");
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                // Degree
                try {
                    DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format("degreeFast.txt")));
                    Scanner sc = new Scanner(textFileStream);
                    while (sc.hasNextLine()) {
                        degreeFetch = sc.nextLine();
                    }
                    degreeArrayFast = degreeFetch.split(",");
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }






                // Main algorithm to find merits.

                try {
                    for (int i = 0; i < yearsArrayFast.length; i++) {

                        if (yearFast.getText().toString().toUpperCase().equals(yearsArrayFast[i])) {
                            indexYears = i;
                            break;
                        }
                        iteratorYears++;
                    }

                    for (int j = 0; j < degreeArrayFast.length; j++){

                        if (degreeArrayFast[j].contains(degreeFast.getText().toString().toUpperCase())){
                            indexDegrees = j;
                            break;
                        }
                        iteratorDegrees++;
                    }

                    if (iteratorDegrees < degreeArrayFast.length - 1 && iteratorYears < yearsArrayFast.length - 1) {
                        displayFast.setText("For the session " + yearsArrayFast[indexYears] + " last merit for " + degreeArrayFast[indexDegrees] + " was " + meritArrayFast[indexYears][indexDegrees]);
                        iteratorYears = 0;
                        iteratorDegrees = 0;
                    }
                    else{
                        displayFast.setText("Can't find anything. Try entering valid numeric inputs.");
                        iteratorYears = 0;
                        iteratorDegrees = 0;
                    }
                }
                catch (Exception e){
                    Toast.makeText(FastMeritSearch.this, "Couldn't find anything", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}