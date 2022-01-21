package com.example.example6_10;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    ActionBar supportActionBar = getSupportActionBar();
    if(supportActionBar != null) {
      supportActionBar.setDisplayHomeAsUpEnabled(true);
      supportActionBar.setIcon(R.drawable.ic_launcher_foreground);
    }

    String[] items = { "ele1", "ele2", "ele3", "ele4", "ele5"};
    AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
    MultiAutoCompleteTextView multiAutoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);

    ArrayAdapter<String> adapter =
        new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);
    autoCompleteTextView.setAdapter(adapter);

    MultiAutoCompleteTextView.CommaTokenizer commaTokenizer = new MultiAutoCompleteTextView.CommaTokenizer();
    multiAutoCompleteTextView.setTokenizer(commaTokenizer);
    ArrayAdapter<String> adapter2 =
        new ArrayAdapter<>(this, android.R.layout.select_dialog_multichoice, items);

    multiAutoCompleteTextView.setAdapter(adapter2);







  }
}