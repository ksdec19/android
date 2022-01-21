package com.example.example6_13;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setIcon(R.drawable.ic_launcher_foreground);
    }

    EditText editText = findViewById(R.id.editText);
    Button button = findViewById(R.id.button);
    TextView textView = findViewById(R.id.textView);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String str = editText.getText().toString();
        textView.append(str);
      }
    });


  }
}