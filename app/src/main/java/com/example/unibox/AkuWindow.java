package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AkuWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aku_window);
    }

    // QS Ranking
    public void intRankingQSAku(View v){
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
    public void hecRankingAku(View v){
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
    public void searchMapAku(View v){
        try {
            Uri uri = Uri.parse("geo:0, 0?q=Aga Khan University");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Oops! Couldn't open the site, try again later.", Toast.LENGTH_SHORT).show();
        }
    }
    // Application
    public void applicationAku(View v){
        try{
            Uri uri = Uri.parse("https://www.aku.edu/admissions/mbbs/Pages/home.aspx");
            Intent web = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(web);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Oops! Couldn't open the site, try again later.", Toast.LENGTH_SHORT).show();
        }
    }

    // Merit Calculator
    public void meritCalculatorOpenAku(View v){
        Intent intent = new Intent(this, MeritCalculatorAku.class);
        startActivity(intent);
    }
}