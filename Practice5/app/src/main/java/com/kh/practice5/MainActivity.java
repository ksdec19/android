package com.kh.practice5;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice5_6);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=  null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setIcon(R.drawable.ic_launcher_foreground);
        }
        setTitle("연습문제 5-6");

        findViewById(R.id.layout1).setOnClickListener(view -> printMsg(view.getWidth() + " : " + view.getWidth()));
        findViewById(R.id.layout2).setOnClickListener(view -> printMsg(view.getWidth() + " : " + view.getWidth()));
        findViewById(R.id.layout3).setOnClickListener(view -> printMsg(view.getWidth() + " : " + view.getWidth()));


    }

    private void printMsg(String info) {
        Toast.makeText(getApplicationContext(), info, Toast.LENGTH_SHORT).show();
    }
}