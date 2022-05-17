package com.example.project_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Scanner;


public class Stage1 extends Activity {
    public String[] story = new String[2];
    public int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        story[0] = "대충 2번 스토리";
        story[1] = "대충 3번 스토리";
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.stage1);
        TextView str1 = (TextView) findViewById(R.id.textView1);
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
}
