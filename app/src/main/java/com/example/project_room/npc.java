package com.example.project_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class npc extends Activity {
    TextView str;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.npc);
    }
    public void onUpgradeBtn(View view){
        str = (TextView) findViewById(R.id.up_text);
        str.setVisibility(View.VISIBLE);
        str.setText("강화 불가\n\n강화 가능한 아이템 종류 : 무기, 방어구, 아티팩트\n강화시 강화석 필요");
        str.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {str.setVisibility(View.GONE);}
        });
    }
    public void onBreakBtn(View view){
        str = (TextView) findViewById(R.id.up_text);
        str.setText("해체 불가\n\n경고! 해체 불가능한 귀속 아이템 입니다. \n아이템 해체시 일정 확률로 강화석 획득");
        str.setVisibility(View.VISIBLE);
    }
}
