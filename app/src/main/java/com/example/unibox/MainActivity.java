package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    // Engineering
    ImageView nustEng;
    ImageView pieasEng;
    ImageView gikiEng;
    ImageView uetEng;
    ImageView auEng;

    // IT
    ImageView comsatsIT;
    ImageView fastIT;
    ImageView nustIT;
    ImageView ituIT;
    ImageView pucitIT;

    // Business
    ImageView lums;
    ImageView iba;

    // Medical
    ImageView agaKhan;
    ImageView uhs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ID's Engineering
        nustEng = findViewById(R.id.nustMainIcon);
        pieasEng = findViewById(R.id.pieasMainIcon);
        gikiEng = findViewById(R.id.gikiMainIcon);
        uetEng = findViewById(R.id.uetMainIcon);
        auEng = findViewById(R.id.airMainIcon);

        // ID's IT
        comsatsIT = findViewById(R.id.comsatsMainIcon);
        fastIT = findViewById(R.id.fastMainIcon);
        nustIT = findViewById(R.id.nustCS);
        ituIT = findViewById(R.id.ituMainIcon);
        pucitIT = findViewById(R.id.pucitMainIcon);

        // Business ID's
        lums = findViewById(R.id.lumsMainIcon);
        iba = findViewById(R.id.ibaMainIcon);

        // Medical ID's
        agaKhan = findViewById(R.id.akuMainIcon);
        uhs = findViewById(R.id.pmcMainIcon);

    }
    // NUST window open
    public void NustEngWindowOpen(View v ){
        Intent intent = new Intent(this, NustEngWindow.class);
        startActivity(intent);
    }

    // PIEAS Window open
    public void PieasWindowOpen(View v){
        Intent intent = new Intent(this, PieasWindow.class);
        startActivity(intent);
    }

    // GIKI window opening
    public void GikiWindowOpen(View v){
        Intent intent = new Intent(this, GikiWindow.class);
        startActivity(intent);
    }

    //UET Window opening
    public void uetWindowOpen(View v){
        Intent intent = new Intent(this, UetWindow.class);
        startActivity(intent);
    }

    // Air Opening
    public void AirWindowOpen(View v){
        Intent intent = new Intent(this, AirUniversityWindow.class);
        startActivity(intent);
    }

    // COMSATS Opening
    public void ComsatsWindowOpen(View v){
        Intent intent = new Intent(this, ComsatsWindow.class);
        startActivity(intent);
    }

    // FAST Opening
    public void FastWindowOpen(View v){
        Intent intent = new Intent(this, FastWindow.class);
        startActivity(intent);
    }

    // ITU Opening
    public void ItuWindowOpen(View v){
        Intent intent = new Intent(this, ItuWindow.class);
        startActivity(intent);
    }

    // PUCIT Opening
    public void PucitWindowOpen(View v){
        Intent intent = new Intent(this, PucitWindow.class);
        startActivity(intent);
    }

    // Lums Opening
    public void lumsOpening(View v){
        Intent intent = new Intent(this, LumsWindow.class);
        startActivity(intent);
    }

    // IBA Opening
    public void ibaOpening(View v){
        Intent intent = new Intent(this, IbaWindow.class);
        startActivity(intent);
    }

    // AKU Opening
    public void akuWindowOpen(View v){
        Intent intent = new Intent(this, AkuWindow.class);
        startActivity(intent);
    }

    // PMC Opening
    public void pmcWindowOpen(View v){
        Intent intent = new Intent(this, PmcWindow.class);
        startActivity(intent);
    }

    // Suggestion Windows Opening
    public void suggestionWindowOpen(View v){
        Intent intent = new Intent(this, SuggestionWindow.class);
        startActivity(intent);
    }

}