package com.example.project_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

public class npc extends Activity {
    TextView str;
    ImageView img;
    int count = 0;
    String stone = "";
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.npc);
        dataSetting();
    }
    public void onUpgradeBtn(View view){
        img = (ImageView) findViewById(R.id.itemView);
        str = (TextView) findViewById(R.id.up_text);
        str.setVisibility(View.VISIBLE);
        Button b0 = (Button) findViewById(R.id.b0);
        if(data.whatItem.equals("sword")){
            Button s1 = (Button) findViewById(R.id.stone1);
            Button s2 = (Button) findViewById(R.id.stone2);
            s1.setVisibility(View.VISIBLE);
            s2.setVisibility(View.VISIBLE);
            str.setText("강화석을 선택해 주세요.\n\n 이 무기는 강화석이 2개 필요합니다. \n선택 후 클릭");
            data.onEnchant = true;
            str.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(data.enchantStones[0] == 1 && data.enchantStones[1] == 1){
                        str.setText("강화 성공 \n\n +??? ???의 힘이 깃든 검 획득!");
                        s1.setVisibility(View.GONE);
                        s2.setVisibility(View.GONE);
                        img.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.sword_up));
                        data.whatItem="sword_up";
                        data.haveSword = false;
                        data.haveUpSword = true;
                        b0.setBackgroundResource(R.drawable.sword_up);
                    }
                    else{
                        str.setText("강화 불가 \n\n 사용할 수 없는 강화석 혹은 강화석 부족 \n강화석을 다시 지정해 주세요.");
                        s1.setVisibility(View.GONE);
                        s2.setVisibility(View.GONE);
                        count = 0;
                        stone = "";
                        s1.setBackgroundResource(R.drawable.resource_null);
                        s2.setBackgroundResource(R.drawable.resource_null);
                        data.onEnchant = false;
                    }
                    str.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            str.setVisibility(View.GONE);
                        }
                    });
                }
            });
        }
        else if(data.whatItem.equals("")){
            str.setText("아이템을 선택해주세요 \n\n 아이템 클릭으로 선택 가능");
            str.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str.setVisibility(View.GONE);
                }
            });
        }
        else if(data.whatItem.equals("sword_up")){
            str.setVisibility(View.GONE);
            Toast.makeText(this,"<System.Error>\n<알수없는 접근 감지 #$^@!1 불가 #$@!$>",Toast.LENGTH_SHORT).show();
            finish();
        }
        else {
            str.setText("강화 불가\n\n강화 가능한 아이템 종류 : 무기, 방어구, 아티팩트\n강화시 강화석 필요");
            str.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str.setVisibility(View.GONE);
                }
            });
        }
    }
    public void onBreakBtn(View view){
        img = (ImageView) findViewById(R.id.itemView);
        str = (TextView) findViewById(R.id.up_text);
        str.setVisibility(View.VISIBLE);
        if(data.whatItem.equals("keyboard")){
            str.setText("해체 대성공!!!\n\n강화석 5개 획득\nEsc,Insert,Delete,Shift,Ctrl");
            data.whatItem="";
            data.haveKeyBoard = false;
            data.haveEnchantStones = true;
            img.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.resource_null));
            dataSetting();
        }
        else if(data.whatItem.equals("")){
            str.setText("아이템을 선택해주세요 \n\n 아이템 클릭으로 선택 가능");
        }
        else if(data.whatItem.equals("sword_up")){
            str.setVisibility(View.GONE);
            Toast.makeText(this,"<System.Error>\n<알수없는 접근 감지 #$^@!1 불가 #$@!$>",Toast.LENGTH_SHORT).show();
            finish();
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
        Button [] stone_i = new Button[2];
        stone_i[0] = (Button)findViewById(R.id.stone1);
        stone_i[1] = (Button)findViewById(R.id.stone2);
        img = (ImageView) findViewById(R.id.itemView);
        if (b_i.getId()==R.id.b0){
            img.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.sword));
            data.whatItem = "sword";
        }
        else if (data.haveKeyBoard){
            if(b_i.getId()==R.id.b1){
                img.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.keyboard));
                data.whatItem = "keyboard";
            }
        }
        else{
            if(data.haveEnchantStones && data.onEnchant && count<2){
                if(b_i.getId()==R.id.b1){//ctrl
                    data.enchantStones[count] = 2;
                    stone_i[count].setBackgroundResource(R.drawable.keyboard_ctrl);
                    count += 1;
                }
                if(b_i.getId()==R.id.b2){//delete
                    if(stone.equals("delete")){
                        data.enchantStones[count] = 2;
                    }
                    else {
                        data.enchantStones[count] = 1;
                        stone = "delete";
                    }
                    stone_i[count].setBackgroundResource(R.drawable.keyboard_delete);
                    count += 1;
                }
                if(b_i.getId()==R.id.b3) {//esc
                    data.enchantStones[count] = 2;
                    stone_i[count].setBackgroundResource(R.drawable.keyboard_esc);
                    count += 1;
                }
                if(b_i.getId()==R.id.b4){//insert
                    data.enchantStones[count] = 2;
                    stone_i[count].setBackgroundResource(R.drawable.keyboard_insert);
                    count += 1;
                }
                if(b_i.getId()==R.id.b5){//shift
                    if(stone.equals("shift")){
                        data.enchantStones[count] = 2;
                    }
                    else {
                        data.enchantStones[count] = 1;
                        stone = "shift";
                    }
                    stone_i[count].setBackgroundResource(R.drawable.keyboard_shift);
                    count += 1;
                }
            }
        }

    }
    private void dataSetting(){
        Button b0 = (Button)findViewById(R.id.b0);
        Button b1 = (Button)findViewById(R.id.b1);
        Button b2 = (Button)findViewById(R.id.b2);
        Button b3 = (Button)findViewById(R.id.b3);
        Button b4 = (Button)findViewById(R.id.b4);
        Button b5 = (Button)findViewById(R.id.b5);
        if (false){

        }
        if (data.haveKeyBoard){
            b1.setBackgroundResource(R.drawable.keyboard);
        }
        else {
            if(data.haveEnchantStones){
                b1.setBackgroundResource(R.drawable.keyboard_ctrl);
                b2.setBackgroundResource(R.drawable.keyboard_delete);
                b3.setBackgroundResource(R.drawable.keyboard_esc);
                b4.setBackgroundResource(R.drawable.keyboard_insert);
                b5.setBackgroundResource(R.drawable.keyboard_shift);
            }
        }

    }
}
