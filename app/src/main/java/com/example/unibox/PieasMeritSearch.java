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

public class PieasMeritSearch extends AppCompatActivity {

    EditText yearPieas;
    EditText programNamePieas;

    Button searchPieas;
    int iteratorYears = 0;
    int iteratorDegrees = 0;
    TextView displayPieas;
    int indexDegrees = 0;
    int indexYears = 0;

    String yearString = "";
    String degreeString = "";

    public String[] yearsPieas;
    public String[] degrees;
    public String[][] degreePieas = {{"800", "695", "557", "554","529", "278"},{"537", "456", "588", "453","373","135"},{"550", "555", "501", "442","331","128"},{"521", "596", "531", "476","312","111"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pieas_merit_search);

        yearPieas = findViewById(R.id.yearPieas);
        programNamePieas = findViewById(R.id.programNamePieas);
        searchPieas = findViewById(R.id.searchPieas);
        displayPieas = findViewById(R.id.displayPieas);

        searchPieas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // years
                try {
                    DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("yearsPieas.txt")));
                    Scanner sc = new Scanner(mainStream);
                    while (sc.hasNext()){
                        yearString = sc.nextLine();
                    }

                    yearsPieas = yearString.split(",");
                    sc.close();
                }
                catch (IOException e){
                    Toast.makeText(PieasMeritSearch.this, "Can't find anything right now", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }


                // Degree
                try {
                    DataInputStream mainStream = new DataInputStream(getAssets().open(String.format("degreePieas.txt")));
                    Scanner sc = new Scanner(mainStream);
                    while (sc.hasNextLine()){
                        degreeString = sc.nextLine();
                    }

                    degrees = degreeString.split(",");
                    sc.close();
                }
                catch (IOException e){
                    Toast.makeText(PieasMeritSearch.this, "Can't find anything right now", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }




                // Main algorithm to find merits.

                try {
                    for (int i = 0; i < yearsPieas.length; i++) {

                        if (yearPieas.getText().toString().toUpperCase().equals(yearsPieas[i])) {
                            indexYears = i;
                            break;
                        }
                        iteratorYears++;
                    }

                    for (int j = 0; j < degrees.length; j++){

                        if (degrees[j].contains(programNamePieas.getText().toString().toUpperCase())){
                            indexDegrees = j;
                            break;
                        }
                        iteratorDegrees++;
                    }

                    if (iteratorDegrees < (degrees.length - 1) && iteratorYears < (yearsPieas.length - 1)) {
                        displayPieas.setText("For the session " + yearsPieas[indexYears] + " last merit for " + degrees[indexDegrees] + " was " + degreePieas[indexYears][indexDegrees]);
                        iteratorYears = 1;
                        iteratorDegrees = 1;
                    }
                    else{
                        displayPieas.setText("Can't find anything. Try entering valid numeric inputs.");
                        iteratorYears = 0;
                        iteratorDegrees = 0;
                    }
                }
                catch (Exception e){
                    Toast.makeText(PieasMeritSearch.this, "Couldn't find anything", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}