package com.example.project_room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button start_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT); //세로화면 고정
        setContentView(R.layout.activity_main); //activity_main을 이용하는 java 파일
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //layout을 화면에 fullscreen으로 보이게함
        getSupportActionBar().hide();
    }
    public void onBtnStart(View view){ //Start Button 클릭시 실행
        Intent intent = new Intent(this, Stage_final.class);
        startActivity(intent); //Stage3를 화면에 띄움
    }
}