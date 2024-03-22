package com.example.lovetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

public class WaitActivity extends AppCompatActivity {

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);

        //recuperare l'Intent ricevuta dalla MainActivity
        handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(() -> callResult(intent), 3000);
    }

    private void callResult(Intent intent) {
        //creare una nuova Intent con cui passare i dati alla successiva Activity

        //il finish serve per terminare l'Activity attuale
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //è opportuno svuotare l'handler per non occupare inutilmente risorse
        handler.removeCallbacksAndMessages(null);
    }
}
