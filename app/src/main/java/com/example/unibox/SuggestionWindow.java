package com.example.unibox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuggestionWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion_window);
    }

    // Medical

    public void MedicalSuggestionOpen(View v){
        Intent intent = new Intent(this, MedicalSuggestion.class);
        startActivity(intent);
    }

    // Engineering

    public void EngSuggest(View view) {
        Intent intent = new Intent(this, EngineeringSuggestion.class);
        startActivity(intent);
    }

    // IT

    public void ItSuggest(View view) {
        Intent intent = new Intent(this, ITSuggestion.class);
        startActivity(intent);
    }
}