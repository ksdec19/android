package com.kh.project4_2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    Switch btnSwitch;
    ViewGroup linearLayout;
    Button button;
    RadioGroup radioGroup;
    ImageView imageView;

    RadioButton[] radioButtons = new RadioButton[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 앱 아이콘
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowHomeEnabled(true);
        supportActionBar.setIcon(R.drawable.ic_launcher);

        //앱 타이틀
        setTitle("애완동물 사진 보기");

        // 뷰 참조해오기
        btnSwitch = findViewById(R.id.switch1);
        linearLayout = findViewById(R.id.con1);
        button = findViewById(R.id.btnFinish);
        radioGroup = findViewById(R.id.rg);
        imageView = findViewById(R.id.iv);

        radioButtons[0] = findViewById(R.id.BtnR1);
        radioButtons[1] = findViewById(R.id.BtnR2);
        radioButtons[2] = findViewById(R.id.BtnR3);

        // 이벤트 등록 및 핸들러 구현
        btnSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d(TAG, compoundButton.toString());

                // 체크했을 경우
                if(btnSwitch.isChecked()){
                    linearLayout.setVisibility(View.VISIBLE);

                //체크하지 않을 경우
                } else {
                    linearLayout.setVisibility((View.INVISIBLE));

                    // 라디오버튼 unchecked로 초기화
                    for(RadioButton rb : radioButtons){
                        if(rb.isChecked()){
                            rb.setChecked(false);

                        }
                    }

                }


            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.BtnR1:
                        imageView.setImageResource(R.drawable.dog1);
                        break;
                    case R.id.BtnR2:
                        imageView.setImageResource(R.drawable.cat1);
                        break;
                    case R.id.BtnR3:
                        imageView.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물을 선택하세요!", Toast.LENGTH_SHORT).show();

                }
            }
        });



    }
}