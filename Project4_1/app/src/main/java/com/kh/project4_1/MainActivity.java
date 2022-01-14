package com.kh.project4_1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText[] editTexts = new EditText[2];     //피연산자
    Button[] buttons = new Button[4];           //4칙연산
    TextView textView;                          //결과값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        final ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowHomeEnabled(true);
        supportActionBar.setIcon(R.drawable.ic_launcher);

        editTexts[0] = findViewById(R.id.Edit1);
        editTexts[1] = findViewById(R.id.Edit2);



        buttons[0] = findViewById(R.id.BtnAdd);
        buttons[1] = findViewById(R.id.BtnMin);
        buttons[2] = findViewById(R.id.BtnMul);
        buttons[3] = findViewById(R.id.BtnDiv);

        textView = findViewById(R.id.TextResult);

        //덧셈
        buttons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String op1 = editTexts[0].getText().toString();
                String op2 = editTexts[1].getText().toString();

                Log.d("add : ", op1);
                Log.d("add : ", op2);

                textView.setText("덧셈결과 : " + String.valueOf(Double.valueOf(op1) + Double.valueOf(op2)));
            }
        });
        //뺄셈
        buttons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String op1 = editTexts[0].getText().toString();
                String op2 = editTexts[1].getText().toString();

                Log.d("min : ", op1);
                Log.d("min : ", op2);

                textView.setText("뺄셈결과 : " + String.valueOf(Double.valueOf(op1) - Double.valueOf(op2)));
            }
        });
        //곱셈
        buttons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String op1 = editTexts[0].getText().toString();
                String op2 = editTexts[1].getText().toString();

                Log.d("mul : ", op1);
                Log.d("mul : ", op2);

                textView.setText("곱셈결과 : " + String.valueOf(Double.valueOf(op1) * Double.valueOf(op2)));
            }
        });
        //나눗셈
        buttons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String op1 = editTexts[0].getText().toString();
                String op2 = editTexts[1].getText().toString();

                Log.d("div : ", op1);
                Log.d("div : ", op2);

                textView.setText("나눗셈결과 : " + String.valueOf(Double.valueOf(op1) / Double.valueOf(op2)));
            }
        });



    }
}