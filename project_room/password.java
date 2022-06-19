package com.example.project_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class password extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.password);
    }
    public void input(View view){
        Button bt = (Button)findViewById(view.getId());
        TextView tv = (TextView) findViewById(R.id.password);
        String n = data.passWordNum;
        if(bt.getId() == R.id.button1){
            n += "1";
        }
        if(bt.getId() == R.id.button2){
            n += "2";
        }
        if(bt.getId() == R.id.button3){
            n += "3";
        }
        if(bt.getId() == R.id.button4){
            n += "4";
        }
        if(bt.getId() == R.id.button5){
            n += "5";
        }
        if(bt.getId() == R.id.button6){
            n += "6";
        }
        if(bt.getId() == R.id.button7){
            n += "7";
        }
        if(bt.getId() == R.id.button8){
            n += "8";
        }
        if(bt.getId() == R.id.button9){
            n += "9";
        }
        data.passWordNum = n;
        tv.setText(n);
    }
    public void oninputBtn(View view){
        TextView tv = (TextView)findViewById(R.id.password);
        if (tv.getText().equals("4829")) {
            if(data.correctNum == false) {
                data.passWordNum = "";
                Toast.makeText(this, "<System.Correct.Number>\n<아이템 $#@! 제공 #$#에 사용>", Toast.LENGTH_SHORT).show();
                data.correctNum = true;
                data.haveKeyBoard = true;
                finish();
            }
            else{
                Toast.makeText(this,"<System.#$#@.Num##$1>\n<오류 1@#*! 이미 적용된 @!#$>",Toast.LENGTH_SHORT).show();
                data.passWordNum = "";
                tv.setText(data.passWordNum);
            }
        }
        else{
            data.passWordNum = "";
            tv.setText(data.passWordNum);
            Toast.makeText(this,"<System.Wron#@.Number>\n<재입력 $%$#>",Toast.LENGTH_SHORT).show();
        }
    }
    public void onoutBtn(View view){
        data.passWordNum = "";
        finish();
    }
}
