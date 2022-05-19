package com.example.project_room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Scanner;


public class Stage1 extends Activity {
    public String[] story = new String[2];
    public int i = 0;
    Button keyBtn,chestBtn;
    ArrayList<MyItem> inventory;
    ItemAdapter adapter;
    TextView str2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        story[0] = "대충 2번 스토리";
        story[1] = "대충 3번 스토리";
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.stage1);
        TextView str1 = (TextView) findViewById(R.id.textView1);
        str1.setVisibility(View.VISIBLE);
        str1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(i<2) {
                    str1.setText(story[i]);
                    i+=1;
                }
                else{
                    str1.setVisibility(View.GONE);
                }
            }
        });
    }
    public void onChestBtn(View view){
        str2 = (TextView) findViewById(R.id.textView2);
        chestBtn = (Button)findViewById(R.id.chestBtn);
        str2.setVisibility(View.VISIBLE);
        if (data.haveMemo){
            str2.setText("메모 말곤 더 없다.");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
        else if (data.haveKey){
            str2.setText("메모를 획득했다.");
            chestBtn.setBackgroundResource(R.drawable.img);
            data.haveKey = false;
            data.haveMemo = true;
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
        else{
            str2.setText("상자는 잠겨있다");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
    }
    public void onKeyBtn(View view){ //keyBtn 클릭시 실행되는 코드
        str2 = (TextView) findViewById(R.id.textView2);
        keyBtn = (Button)findViewById(R.id.keyBtn);
        str2.setVisibility(View.VISIBLE);
        str2.setText("열쇠를 획득하였다.");
        keyBtn.setVisibility(View.GONE);
        data.haveKey = true;
        str2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str2.setVisibility(View.GONE);

            }
        });
    }
    public void onInBtn(View view){
        Intent intent = new Intent(Stage1.this,Inventory.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){
        return; //안드로이드 백버튼 막기
    }
}
