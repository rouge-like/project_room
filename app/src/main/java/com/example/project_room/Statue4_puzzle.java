package com.example.project_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Statue4_puzzle extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.password4);
    }
    public void input(View view){
        Button bt = (Button)findViewById(view.getId());
        TextView tv = (TextView) findViewById(R.id.password);
        String n = data.passWordNum;
        if(bt.getId() == R.id.button1){
            n += "a";
        }
        if(bt.getId() == R.id.button2){
            n += "e";
        }
        if(bt.getId() == R.id.button3){
            n += "i";
        }
        if(bt.getId() == R.id.button4){
            n += "o";
        }
        if(bt.getId() == R.id.button5){
            n += "u";
        }
        if(bt.getId() == R.id.button6){
            n += "h";
        }
        if(bt.getId() == R.id.button7){
            n += "l";
        }
        if(bt.getId() == R.id.button8){
            n += "t";
        }
        if(bt.getId() == R.id.button9){
            n += "d";
        }
        data.passWordNum = n;
        tv.setText(n);
    }
    public void oninputBtn(View view){
        TextView tv = (TextView)findViewById(R.id.password);
        if (tv.getText().equals("death")) {
            Toast.makeText(this,"박스가 열립니다.",Toast.LENGTH_SHORT).show();
            data.st2_box4opened = true;
            data.st2_key4 = true;
            data.passWordNum = "";
            finish();
        } else {
            Toast.makeText(this,"잘못된 비밀번호입니다.",Toast.LENGTH_SHORT).show();
            data.passWordNum = "";
            tv.setText(data.passWordNum);
        }
    }

    public void onoutBtn(View view){
        data.passWordNum = "";
        finish();
    }
}
