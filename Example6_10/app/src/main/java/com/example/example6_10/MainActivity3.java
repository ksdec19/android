package com.example.example6_10;

import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {

  private static final String TAG = "MainActivity2";
  Handler handler = new Handler();
  private ProgressBar progressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.progressvar);

    progressBar = findViewById(R.id.progressBar);

    new Thread(new Runnable() {
      int value = 0;
      @Override
      public void run() {

        for(int i=0; i<=100; i++){
          handler.post(() -> progressBar.setProgress(++value));

          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }).start();
  }
}