package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FastWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fast_window);
    }
    // QS Ranking
    public void intRankingQSFAST(View v){
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
    public void hecRankingFAST(View v){
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
    public void searchMapFAST(View v){
        try {
            Uri uri = Uri.parse("geo:0, 0?q=FAST NUCES");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Oops! Couldn't open the site, try again later.", Toast.LENGTH_SHORT).show();
        }
    }
    // Application
    public void applicationFAST(View v){
        try{
            Uri uri = Uri.parse("http://admissions.nu.edu.pk/OLAR/Login");
            Intent web = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(web);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Oops! Couldn't open the site, try again later.", Toast.LENGTH_SHORT).show();
        }
    }
    // Merit Calculator
    public void fastMeritCalculatorOpen(View v){
        Intent intent = new Intent(this, FastMeritCalculator.class);
        startActivity(intent);
    }
}