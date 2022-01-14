package com.kh.fourbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button[] buttons = new Button[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons[0] = (Button) findViewById(R.id.btnNate);
        buttons[1] = (Button) findViewById(R.id.btn911);
        buttons[2] = (Button) findViewById(R.id.btnGal);
        buttons[3] = (Button) findViewById(R.id.btnEnd);

        buttons[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"));
                startActivity(intent);
            }
        });
        buttons[1].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
        buttons[2].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });
        buttons[3].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });




    }
}