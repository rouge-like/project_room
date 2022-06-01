package com.example.project_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class npc extends Activity {
    TextView str;
    ImageView img;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.npc);
    }
    public void onUpgradeBtn(View view){
        str = (TextView) findViewById(R.id.up_text);
        str.setVisibility(View.VISIBLE);
        if(data.whatItem.equals("sword")){
            str.setText("강화석을 선택해 주세요.\n\n 이 무기는 강화석이 2개 필요합니다. \n선택 후 클릭");
            str.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(data.enchantStones[0] == 1 && data.enchantStones[1]==1){
                        str.setText("강화 성공 \n\n +??? ???의 힘이 깃든 검 획득!");
                    }
                    else{
                        str.setText("강화 불가 \n\n 사용할 수 없는 강화석 \n강화석을 다시 지정해 주세요.");
                    }
                }
            });
        }
        else if(data.whatItem.equals("")){
            str.setText("아이템을 선택해주세요 \n\n 아이템 클릭으로 선택 가능");
        }
        else {
            str.setText("강화 불가\n\n강화 가능한 아이템 종류 : 무기, 방어구, 아티팩트\n강화시 강화석 필요");
        }
        str.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.setVisibility(View.GONE);
            }
        });
    }
    public void onBreakBtn(View view){
        Button b1 = (Button)findViewById(R.id.b1);
        Button b2 = (Button)findViewById(R.id.b2);
        Button b3 = (Button)findViewById(R.id.b3);
        Button b4 = (Button)findViewById(R.id.b4);
        Button b5 = (Button)findViewById(R.id.b5);
        img = (ImageView) findViewById(R.id.itemView);
        str = (TextView) findViewById(R.id.up_text);
        str.setVisibility(View.VISIBLE);
        if(data.whatItem.equals("keyboard")){
            str.setText("해체 대성공!!!\n\n강화석 5개 획득\nEsc,Insert,Delete,Shift,Ctrl");
            data.whatItem="";
            data.haveKeyBoard = false;
            data.haveEnchantStones = true;
            img.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.resource_null));
            b1.setBackgroundResource(R.drawable.img);
            b2.setBackgroundResource(R.drawable.img);
            b3.setBackgroundResource(R.drawable.img);
            b4.setBackgroundResource(R.drawable.img);
            b5.setBackgroundResource(R.drawable.img);
        }
        else if(data.whatItem.equals("")){
            str.setText("아이템을 선택해주세요 \n\n 아이템 클릭으로 선택 가능");
        }
        else {
            str.setText("해체 불가\n\n해체 불가능한 아이템 종류 : 귀속 아이템, 아티팩트 \n아이템 해체시 일정 확률로 강화석 획득");
        }
        str.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.setVisibility(View.GONE);
            }
        });
    }
    public void onB(View view){
        Button b_i = (Button) findViewById(view.getId());
        img = (ImageView) findViewById(R.id.itemView);
        if (b_i.getId()==R.id.b0){
            img.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img));
            data.whatItem = "sword";
        }
        else if (data.haveKeyBoard){
            if(b_i.getId()==R.id.b1){
                img.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.keyboard));
                data.whatItem = "keyboard";
            }
        }

    }
}
