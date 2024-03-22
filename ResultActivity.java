package com.example.lovetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    
    private TextView resultPerc;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        
        resultPerc = findViewById(R.id.perc_result);
        resultText = findViewById(R.id.text_result);
        Button backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(v -> finish());

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("first_name");
        String secondName = intent.getStringExtra("second_name");
        
        calculateAffinity(firstName, secondName);
    }

    private void calculateAffinity(String firstName, String secondName) {

        int score = calculateNameScore(firstName) + calculateNameScore(secondName);
        int normalizedScore = normalizeScore(score);

        resultPerc.setText(normalizedScore + "%");
        resultText.setText(firstName+" e "+secondName+" sono compatibili al "+normalizedScore+"%");
    }

    private static int calculateNameScore(String name) {
        int score = 0;
        // Somma i valori ASCII dei caratteri nel nome
        for (int i = 0; i < name.length(); i++) {
            score += (int) name.charAt(i);
        }
        return score;
    }

    private static int normalizeScore(int score) {
        // Normalizza il punteggio nell'intervallo da 0 a 100
        return Math.min(100, Math.max(0, score % 101));
    }
}