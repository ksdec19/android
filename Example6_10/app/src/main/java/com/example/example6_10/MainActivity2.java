package com.example.example6_10;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

  private static final String TAG = "MainActivity2";
  MyHandler handler = new MyHandler();
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
          //progressBar.setProgress(i);
          Message message = handler.obtainMessage();
          Bundle bundle = new Bundle();
          bundle.putInt("value", ++value);
          message.setData(bundle);
          handler.sendMessage(message);

          Log.d(TAG, i+"");
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }).start();
  }
  class MyHandler extends Handler{
    @Override
    public void handleMessage(@NonNull Message msg) {
      super.handleMessage(msg);
      Bundle data = msg.getData();
      int value = data.getInt("value");
      Log.d(TAG, value+"h");
      progressBar.setProgress(value);
    }
  }
}