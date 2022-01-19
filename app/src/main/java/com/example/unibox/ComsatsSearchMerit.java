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


public class ComsatsSearchMerit extends AppCompatActivity {
    EditText yearComsats;
    EditText degreeComsats;
    Button searchComsats;
    TextView displayComsats;
    int iteratorYears = 0;
    int iteratorDegrees = 0;
    int indexDegrees = 0;
    int indexYears = 0;

    String yearsFetch = "";
    String degreeFetch = "";
    public String[] yearsArrayComsats;
    public String[] degreeArrayComsats;
    public String[][] meritArrayComsats = {{"84.50%","83.32%","83.12%","82.01%","82.33%","81.88%"},{"84.69%","83.49%","83.79%","81.47%","82.45%","NIL"},{"86.43%","85.23%","NIL","NIL","NIL","81.25%"},{"82.68%","84.31%","NIL","NIL","NIL","NIL"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comsats_search_merit);
        yearComsats = findViewById(R.id.yearComsats);
        degreeComsats = findViewById(R.id.degreeComsats);
        searchComsats = findViewById(R.id.searchComsats);
        displayComsats = findViewById(R.id.displayComsats);




        searchComsats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // years

                try {
                    DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format("sessionComsats.txt")));
                    Scanner sc = new Scanner(textFileStream);
                    while (sc.hasNextLine()) {
                        yearsFetch = sc.nextLine();
                    }
                    yearsArrayComsats = yearsFetch.split(",");
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                // Degree
                try {
                    DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format("degreeComsats.txt")));
                    Scanner sc = new Scanner(textFileStream);
                    while (sc.hasNextLine()) {
                        degreeFetch = sc.nextLine();
                    }
                     degreeArrayComsats = degreeFetch.split(",");
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }






                // Main algorithm to find merits.

                try {
                    for (int i = 0; i < yearsArrayComsats.length; i++) {

                        if (yearComsats.getText().toString().toUpperCase().equals(yearsArrayComsats[i])) {
                            indexYears = i;
                            break;
                        }
                        iteratorYears++;
                    }

                    for (int j = 0; j < degreeArrayComsats.length; j++){

                        if (degreeArrayComsats[j].contains(degreeComsats.getText().toString().toUpperCase())){
                            indexDegrees = j;
                            break;
                        }
                        iteratorDegrees++;
                    }

                    if (iteratorDegrees < degreeArrayComsats.length - 1 && iteratorYears < yearsArrayComsats.length - 1) {
                        displayComsats.setText("For the session " + yearsArrayComsats[indexYears] + " last merit for " + degreeArrayComsats[indexDegrees] + " was " + meritArrayComsats[indexYears][indexDegrees]);
                        iteratorYears = 0;
                        iteratorDegrees = 0;
                    }
                    else{
                        displayComsats.setText("Can't find anything. Try entering valid numeric inputs.");
                        iteratorYears = 0;
                        iteratorDegrees = 0;
                    }
                }
                catch (Exception e){
                    Toast.makeText(ComsatsSearchMerit.this, "Couldn't find anything", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}