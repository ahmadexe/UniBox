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
public class PmcMeritSearch extends AppCompatActivity {
    EditText yearPmc;
    EditText degreePmc;
    Button searchPmc;
    TextView displayPmc;

    int iteratorYears = 0;
    int iteratorDegrees = 0;
    int indexDegrees = 0;
    int indexYears = 0;

    String yearsFetch = "";
    String degreeFetch = "";
    public String[] yearsArrayPmc;
    public String[] degreeArrayPmc;
    public String[][] meritArrayPmc = {{"90.8%","90.2%"},{"91.6%","90.6%"},{"91.56%","93.5%"},{"89.14%","89.04%"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmc_merit_search);
        yearPmc = findViewById(R.id.yearPmc);
        degreePmc = findViewById(R.id.degreePmc);
        searchPmc = findViewById(R.id.searchPmc);
        displayPmc = findViewById(R.id.displayPmc);

        searchPmc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // years

                try {
                    DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format("sessionPMC.txt")));
                    Scanner sc = new Scanner(textFileStream);
                    while (sc.hasNextLine()) {
                        yearsFetch = sc.nextLine();
                    }
                    yearsArrayPmc = yearsFetch.split(",");
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                // Degree
                try {
                    DataInputStream textFileStream = new DataInputStream(getAssets().open(String.format("degreePmc.txt")));
                    Scanner sc = new Scanner(textFileStream);
                    while (sc.hasNextLine()) {
                        degreeFetch = sc.nextLine();
                    }
                    degreeArrayPmc = degreeFetch.split(",");
                    sc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }






                // Main algorithm to find merits.

                try {
                    for (int i = 0; i < yearsArrayPmc.length; i++) {

                        if (yearPmc.getText().toString().toUpperCase().equals(yearsArrayPmc[i])) {
                            indexYears = i;
                            break;
                        }
                        iteratorYears++;
                    }

                    for (int j = 0; j < degreeArrayPmc.length; j++){

                        if (degreeArrayPmc[j].contains(degreePmc.getText().toString().toUpperCase())){
                            indexDegrees = j;
                            break;
                        }
                        iteratorDegrees++;
                    }

                    if (iteratorDegrees < degreeArrayPmc.length - 1 && iteratorYears < yearsArrayPmc.length - 1) {
                        displayPmc.setText("For the session " + yearsArrayPmc[indexYears] + " last merit for " + degreeArrayPmc[indexDegrees] + " was " + meritArrayPmc[indexYears][indexDegrees]);
                        iteratorYears = 0;
                        iteratorDegrees = 0;
                    }
                    else{
                        displayPmc.setText("Can't find anything. Try entering valid numeric inputs.");
                        iteratorYears = 0;
                        iteratorDegrees = 0;
                    }
                }
                catch (Exception e){
                    Toast.makeText(PmcMeritSearch.this, "Couldn't find anything", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}