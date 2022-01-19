package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class NustEngWindow extends AppCompatActivity {
    ImageView nustInternationalRank;
    ImageView nustHecRank;
    ImageView nustMerit;
    ImageView nustLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nust_eng_window);
        nustHecRank = findViewById(R.id.nustHecRank);
        nustInternationalRank = findViewById(R.id.nustInternationalRank);
        nustMerit = findViewById(R.id.nustMeriCalculator);
        nustLocation = findViewById(R.id.nustLocation);
    }
    // Calculator
    public void nustMeritCalculator(View v){
        Intent intent = new Intent(this, MeritCalculatorNust.class);
        startActivity(intent);
    }

    // QS Ranking
    public void intRankingQS(View v){
        try{
            Uri uri = Uri.parse("https://www.topuniversities.com/university-rankings/world-university-rankings/2022");
            Intent web = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(web);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Oops! Couldn't open the site, try again later.", Toast.LENGTH_SHORT).show();
        }
    }

    // HEC Ranking
    public void hecRanking(View v){
        try{
            Uri uri = Uri.parse("https://hec.gov.pk/english/services/universities/Ranking/2010/Pages/Category-Wise-Rankings.aspx");
            Intent web = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(web);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Oops! Couldn't open the site, try again later.", Toast.LENGTH_SHORT).show();
        }
    }
    
    // Google Maps
    public void searchMap(View v){
        try {
            Uri uri = Uri.parse("geo:0, 0?q=National Univeristy of Science and Technology Islamabad");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Oops! Couldn't open the site, try again later.", Toast.LENGTH_SHORT).show();
        }
    }

    // Application
    public void ApplicationNust(View v){
        try{
            Uri uri = Uri.parse("https://nust.edu.pk/admissions/undergraduates/procedure-of-admission-on-the-basis-of-net/");
            Intent web = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(web);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Oops! Couldn't open the site, try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}