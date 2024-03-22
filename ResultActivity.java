package com.example.lovetest;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        
        //inizializzare i componenti
        //impostare il click listener del bottone
        //recuperare i nomi dall'Intent
        
        calculateAffinity(firstName, secondName);
    }

    private void calculateAffinity(String firstName, String secondName) {

        int score = calculateNameScore(firstName) + calculateNameScore(secondName);
        int normalizedScore = normalizeScore(score);

        //usare il punteggio calcolato per avvalorare i campi di testo sull'interfaccia
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
