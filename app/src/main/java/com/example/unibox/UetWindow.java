package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class UetWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uet_window);
    }
    // Merit calculator
    public void UetMeritCalculatorOpen(View v){
        Intent intent = new Intent(this, UetMeritCalculator.class);
        startActivity(intent);
    }

    // QS Ranking
    public void intRankingQSUET(View v){
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
    public void hecRankingUET(View v){
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
    public void searchMapUET(View v){
        try {
            Uri uri = Uri.parse("geo:0, 0?q=University of Engineering and technology, Lahore");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Oops! Couldn't open the site, try again later.", Toast.LENGTH_SHORT).show();
        }
    }

    // Application
    public void applicationUET(View v){
        try{
            Uri uri = Uri.parse("https://admission.uet.edu.pk/Modules/EntryTest/Default.aspx");
            Intent web = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(web);
        }
        catch (ActivityNotFoundException e){
            Toast.makeText(this, "Oops! Couldn't open the site, try again later.", Toast.LENGTH_SHORT).show();
        }
    }
}