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

public class npc extends Activity { //npc가 띄워주는 강화,분해창을 나타내는 java파일
    TextView str;
    ImageView img;
    int count = 0;
    String stone = "";
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //title을 안보이게 설정
        setContentView(R.layout.npc);
        dataSetting(); //데이터 확인
    }
    public void onUpgradeBtn(View view){ //강화 버튼 클릭 시 실행
        img = (ImageView) findViewById(R.id.itemView); //선택된 아이템 이미지
        str = (TextView) findViewById(R.id.up_text); //출력될 텍스트를 나타낼 TextView
        str.setVisibility(View.VISIBLE); //str을 보이게함
        Button b0 = (Button) findViewById(R.id.b0);
        if(data.whatItem.equals("sword")){ //현재 선택된 아이템이 sword일 경우 실행
            Button s1 = (Button) findViewById(R.id.stone1); //강화석 선택 버튼 1
            Button s2 = (Button) findViewById(R.id.stone2); //강화석 선택 버튼 2
            s1.setVisibility(View.VISIBLE);
            s2.setVisibility(View.VISIBLE); //버튼 s1,s2를 보이게함
            str.setText("강화석을 선택해 주세요.\n\n 이 무기는 강화석이 2개 필요합니다. \n선택 후 클릭");
            data.onEnchant = true; //현재 강화 선택중이므로 true
            str.setOnClickListener(new View.OnClickListener() { //str 클릭시 실행
                @Override
                public void onClick(View v) {
                    if(data.enchantStones[0] == 1 && data.enchantStones[1] == 1){ //올바른 강화석 2개 선택시 실행
                        str.setText("강화 성공 \n\n +??? ???의 힘이 깃든 검 획득!"); //다음 텍스트를 출력
                        s1.setVisibility(View.GONE);
                        s2.setVisibility(View.GONE);//s1,s2를 제거
                        img.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.sword_up)); //img의 이미지를 강화된 검으로 바꿈
                        data.whatItem="sword_up"; //현재 선택된 아이템을 강화된 검 sword_up으로 변경
                        data.haveSword = false; //검을 현재 더이상 갖고있지 않으므로 false
                        data.haveUpSword = true;//강화된 검이 생겼으므로 true
                        b0.setBackgroundResource(R.drawable.sword_up); //검이 있던 선택창의 이미지를 강화된 검으로 변경
                    }
                    else{ //올바르지않은 강화석을 선택했을 경우
                        str.setText("강화 불가 \n\n 사용할 수 없는 강화석 혹은 강화석 부족 \n강화석을 다시 지정해 주세요."); //다음 텍스트 출력
                        s1.setVisibility(View.GONE);
                        s2.setVisibility(View.GONE); //s1,s2를 제거
                        count = 0; // count 변수 초기화
                        stone = ""; // stone 문자열 초기화
                        s1.setBackgroundResource(R.drawable.resource_null);
                        s2.setBackgroundResource(R.drawable.resource_null); //s1,s2의 이미지를 null로 초기화
                        data.onEnchant = false; //강화가 끝났으므르 false로 변경
                    }
                    str.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            str.setVisibility(View.GONE);
                        } //str 클릭시 str 제거
                    });
                }
            });
        }
        else if(data.whatItem.equals("")){ //선택된 아이템이 없을 경우
            str.setText("아이템을 선택해주세요 \n\n 아이템 클릭으로 선택 가능"); //다음 텍스트 출력
            str.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str.setVisibility(View.GONE);
                } //str 클릭시 str 제거
            });
        }
        else if(data.whatItem.equals("sword_up")){ //선택된 아이템이 강화된 검일 경우
            str.setVisibility(View.GONE); //str 제거
            Toast.makeText(this,"<System.Error>\n<알수없는 접근 감지 #$^@!1 불가 #$@!$>",Toast.LENGTH_SHORT).show(); //다음 텍스트 화면 아래 알림
            finish(); //npc layout 종료
        }
        else { //검이 아닌 다른 아이템이 선택되었을 경우
            str.setText("강화 불가\n\n강화 가능한 아이템 종류 : 무기, 방어구, 아티팩트\n강화시 강화석 필요"); //다음텍스트 출력
            str.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str.setVisibility(View.GONE);
                } //str 클릭시 str 제거
            });
        }
    }
    public void onBreakBtn(View view){//분해 버튼 클릭 시 실행
        img = (ImageView) findViewById(R.id.itemView);
        str = (TextView) findViewById(R.id.up_text);
        str.setVisibility(View.VISIBLE);
        if(data.whatItem.equals("keyboard")){ //키보드가 선택되어있을 경우
            str.setText("해체 대성공!!!\n\n강화석 5개 획득\nEsc,Insert,Delete,Shift,Ctrl"); //다음 텍스트 출력
            data.whatItem=""; //선택된 아이템 초기화
            data.haveKeyBoard = false; //키보드가 해체되었으므로 false
            data.haveEnchantStones = true; //강화석을 획득하였으므로 true
            img.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.resource_null)); //선택된 아이템 이미지를 null로 변경
            dataSetting(); //데이터 확인
        }
        else if(data.whatItem.equals("")){ //선택된 아이템이 없을 경우
            str.setText("아이템을 선택해주세요 \n\n 아이템 클릭으로 선택 가능"); //다음 텍스트 출력
        }
        else if(data.whatItem.equals("sword_up")){ //강화된 아이템이 선택되어있을 경우
            str.setVisibility(View.GONE); //str을 제거
            Toast.makeText(this,"<System.Error>\n<알수없는 접근 감지 #$^@!1 불가 #$@!$>",Toast.LENGTH_SHORT).show(); //다음 텍스트 출력
            finish();//npc layout 종료
        }
        else { //다른 아이템이 선택되어있을 경우
            str.setText("해체 불가\n\n해체 불가능한 아이템 종류 : 귀속 아이템, 아티팩트 \n아이템 해체시 일정 확률로 강화석 획득");//다음 텍스트 출력
        }
        str.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.setVisibility(View.GONE);
            }//str 클릭시 str 제거
        });
    }
    public void onB(View view){ //아이템 선택시 실행
        Button b_i = (Button) findViewById(view.getId()); //선택된 아이템의 id를 불러옴
        Button [] stone_i = new Button[2]; //강화석 버튼을 저장
        stone_i[0] = (Button)findViewById(R.id.stone1);//강화석 선택 버튼 1
        stone_i[1] = (Button)findViewById(R.id.stone2); // 강화석 선택 버튼 2
        img = (ImageView) findViewById(R.id.itemView); //선택된 아이템을 보여줄 imageView
        if (b_i.getId()==R.id.b0){ //검 아이템 선택시 실행
            if(data.whatItem.equals("sword_up")){ //강화된 검일 경우
                str.setVisibility(View.GONE);
                Toast.makeText(this,"<System.Error>\n<알수없는 접근 감지 #$^@!1 불가 #$@!$>",Toast.LENGTH_SHORT).show();//다음 텍스트 화면아래 출력
                finish(); //종료
            }
            else {//그냥 검일 경우
                img.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.sword)); //img의 이미지를 검으로 변경
                data.whatItem = "sword"; //선택된 아이템 sword로 설정
            }
        }
        else if (data.haveKeyBoard){ //키보드 아이템 보유시 실행
            if(b_i.getId()==R.id.b1){ //키보드 아이템 선택 시 실행
                img.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.keyboard)); //img의 이미지를 키보드로 변경
                data.whatItem = "keyboard"; //선택된 아이템 keyboard로 설정
            }
        }
        else{//키보드가 없을 경우
            if(data.haveEnchantStones && data.onEnchant && count<2){ //강화석이 있고, 현재 강화중이고, 강화석이 2개다 선택되지 않았을 경우
                if(b_i.getId()==R.id.b1){//ctrl 강화석이 선택 되었을 경우
                    data.enchantStones[count] = 2; //틀린 강화석이므로 2
                    stone_i[count].setBackgroundResource(R.drawable.keyboard_ctrl); //count번째 버튼 이미지를 ctrl로 변경
                    count += 1; //count 상승
                }
                if(b_i.getId()==R.id.b2){//delete 강화석이 선택 되었을 경우
                    if(stone.equals("delete")){ //이전에 선택된 강화석이 delete일 경우, 즉 중복된 강화석 선택 시
                        data.enchantStones[count] = 2; //중복이므로 2
                    }
                    else {
                        data.enchantStones[count] = 1; //올바른 강화석이므로 1
                        stone = "delete"; //전에 선택한 강화석이 delete이므로 저장
                    }
                    stone_i[count].setBackgroundResource(R.drawable.keyboard_delete); //count번째 버튼 이미지를 delete로 변경
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
    private void dataSetting(){ //데이터 확인 함수
        Button b0 = (Button)findViewById(R.id.b0);
        Button b1 = (Button)findViewById(R.id.b1);
        Button b2 = (Button)findViewById(R.id.b2);
        Button b3 = (Button)findViewById(R.id.b3);
        Button b4 = (Button)findViewById(R.id.b4);
        Button b5 = (Button)findViewById(R.id.b5); //각 아이템 버튼들을 불러옴
        if (data.haveSword){
            b0.setBackgroundResource(R.drawable.sword); //검을 갖고있을 시 b0버튼을 검으로 설정
        }
        if (data.haveKeyBoard){
            b1.setBackgroundResource(R.drawable.keyboard); //키보드를 갖고 있을 시 b1 버튼을 키보드로 설정
        }
        else {
            if(data.haveEnchantStones){ //키보드를 갖고있지 않고, 강화석을 갖고 있을 시 b1~b5를 강화석들로 설정
                b1.setBackgroundResource(R.drawable.keyboard_ctrl);
                b2.setBackgroundResource(R.drawable.keyboard_delete);
                b3.setBackgroundResource(R.drawable.keyboard_esc);
                b4.setBackgroundResource(R.drawable.keyboard_insert);
                b5.setBackgroundResource(R.drawable.keyboard_shift);
            }
        }

    }
}
