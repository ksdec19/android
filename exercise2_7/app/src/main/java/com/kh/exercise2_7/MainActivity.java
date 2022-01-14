package com.kh.exercise2_7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button[] buttons = new Button[2];
    RadioButton[] radioButtons = new RadioButton[2];
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // connect UI
        setContentView(R.layout.activity_main);

        // App Icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.appicon);

        // App View Targeting
        editText = findViewById(R.id.editText);
        buttons[0] = findViewById(R.id.btn1);
        buttons[1] = findViewById(R.id.btn2);
        radioButtons[0] = findViewById(R.id.radio1);
        radioButtons[1] = findViewById(R.id.radio2);
        imageView = findViewById(R.id.imageView);

        // Add View Listener and make Handler
        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = (String) editText.getText().toString();
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
            }
        });

        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = (String) editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(intent);
            }
        });
        radioButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               imageView.setImageResource(R.drawable.q);


            }
        });
        radioButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.r);


            }
        });


    }
}