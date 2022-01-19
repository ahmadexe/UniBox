package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PieasWindow extends AppCompatActivity {
    ImageView pieasQSRank;
    ImageView pieasHECRank;
    ImageView pieasMerit;
    ImageView pieasLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pieas_window);
        pieasQSRank = findViewById(R.id.pieasIntRank);
        pieasHECRank = findViewById(R.id.pieasHecRank);
        pieasMerit = findViewById(R.id.pieasMeritCalculator);
        pieasLocation = findViewById(R.id.pieasLocation);

    }
    // Merit Calculator Pieas
    public void pieasMeritCalculatorWindowOpen(View v){
        Intent intent = new Intent(this, PieasMeritCalculator.class);
        startActivity(intent);
    }

    // QS Ranking
    public void intRankingQSPieas(View v){
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
    public void hecRankingPieas(View v){
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
    public void searchMapPieas(View v){
        try {
            Uri uri = Uri.parse("geo:0, 0?q=Pakistan Institute of Engineering and Applied Sciences(PIEAS)");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Oops! Couldn't open the site, try again later.", Toast.LENGTH_SHORT).show();
        }
    }

    // Application
    public void applicationPieas(View v){
        try {
            Uri uri = Uri.parse("https://red.pieas.edu.pk/pieasadmission/lgn.aspx");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        catch (Exception e){
            Toast.makeText(this, "Can't apply right now!", Toast.LENGTH_SHORT).show();
        }
    }
}