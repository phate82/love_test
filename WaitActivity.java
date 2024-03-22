package com.example.lovetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class WaitActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);

        Intent intent = getIntent();
        handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(() -> callResult(intent), 3000);
    }

    private void callResult(Intent intent) {
        Intent resultIntent = new Intent(this, ResultActivity.class);
        resultIntent.putExtras(intent.getExtras());
        startActivity(resultIntent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}