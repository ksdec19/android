package com.kh.project5_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 피연산자
    EditText edit1, edit2;


    // 0~9 버튼
    Button[] btnsOfNum = new Button[10];

    int[] numBtnIds = {
            R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4,
            R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9
    };

    // 4칙연산 : + - * /
    Button[] btnsOfOperand = new Button[4];

    // 계산결과
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.ic_launcher_foreground);

        setTitle("테이블 레이아웃 게산기");

        // 피연산자 참조
        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);

//        edit1.setTextIsSelectable(true);// 커서 살아있다
        edit1.setShowSoftInputOnFocus(false);//키보드 숨긴다
        edit2.setShowSoftInputOnFocus(false);//키보드 숨긴다

        // 0~9버튼 참조
        for(int i=0; i<btnsOfNum.length; i++){
            btnsOfNum[i] = findViewById(numBtnIds[i]);
            int finalI = i;
            btnsOfNum[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // focus 된 editText에 숫자 추가
                    if(edit1.isFocused()){
                        edit1.setText(edit1.getText().toString() + btnsOfNum[finalI].getText().toString());
                    } else if(edit2.isFocused()) {
                        edit2.setText(edit2.getText().toString() + btnsOfNum[finalI].getText().toString());
                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 editText를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        // 사칙연산 버튼 참조
        btnsOfOperand[0] = findViewById(R.id.BtnAdd);
        btnsOfOperand[1] = findViewById(R.id.BtnSub);
        btnsOfOperand[2] = findViewById(R.id.BtnMul);
        btnsOfOperand[3] = findViewById(R.id.BtnDiv);

        // 계산 결과 참조
        result = findViewById(R.id.TextResult);

        btnsOfOperand[0].setOnTouchListener((view, motionEvent) -> {

                if (validateChk()) return false;

                int tmp = Integer.parseInt(edit1.getText().toString()) + Integer.parseInt(edit2.getText().toString());
                result.setText(R.string.result + String.valueOf(tmp));

                setEditTextFocusClear();

                return true;

        });

        btnsOfOperand[1].setOnTouchListener((view, motionEvent) -> {

                if (validateChk()) return false;

                int tmp = Integer.parseInt(edit1.getText().toString()) - Integer.parseInt(edit2.getText().toString());
                result.setText(R.string.result + String.valueOf(tmp));

                setEditTextFocusClear();

                return true;
        });


        btnsOfOperand[2].setOnTouchListener(( view,  motionEvent) -> {

                if (validateChk()) return false;

                int tmp = Integer.parseInt(edit1.getText().toString()) * Integer.parseInt(edit2.getText().toString());
                result.setText(R.string.result + String.valueOf(tmp));

                setEditTextFocusClear();

                return true;

        });


        btnsOfOperand[3].setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

               if (validateChk()) return false;

                double tmp = Integer.parseInt(edit1.getText().toString()) / (double)Integer.parseInt(edit2.getText().toString());
                result.setText(R.string.result + String.valueOf(tmp));

                setEditTextFocusClear();

                return true;
            }
        });



    }

    // 포커스 해제
    private void setEditTextFocusClear() {
        edit1.clearFocus();
        edit2.clearFocus();
    }

    // 피연산자 필수 입력 체크
    private boolean validateChk() {
        if(edit1.getText().toString().trim().length() == 0  ){
            Toast.makeText(getApplicationContext(), "계산할 숫자를 입력하세요!", Toast.LENGTH_SHORT).show();
            edit1.requestFocus();
            return true;
        }
        if(edit2.getText().toString().trim().length() == 0){
            Toast.makeText(getApplicationContext(), "계산할 숫자를 입력하세요!", Toast.LENGTH_SHORT).show();
            edit2.requestFocus();
            return true;
        }
        return false;
    }
}