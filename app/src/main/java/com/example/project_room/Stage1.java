package com.example.project_room;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.charset.StandardCharsets;


public class Stage1 extends Activity {
    public String[] story = new String[2]; // 스토리 텍스트를 저장하는 String array
    public int i = 0;
    public String s="안녕";
    Button keyBtn, chestBtn;
    TextView str1, str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        story[0] = "너무 어둡다..잘 보이지 않는다.";
        story[1] = "주변에 횃불이 있을 것 같다 찾아보자.";
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.stage1);
        str1 = (TextView) findViewById(R.id.textView1); //textView1 텍스트뷰를 불러옴 str1으로 설정
        str1.setVisibility(View.VISIBLE); //str1을 보이게 설정
        str1.setOnClickListener(new View.OnClickListener() { //str1 클릭시 실행
            @Override
            public void onClick(View v) {
                if (i < 2) { //스토리 텍스트 2줄 출력해줌
                    str1.setText(story[i]);
                    i += 1;
                } else { //2줄 보여준후 str1을 제거
                    str1.setVisibility(View.GONE);
                }
            }
        });
    }
    public void onChestBtn(View view) { //chest button 클릭시 실행
        str2 = (TextView) findViewById(R.id.textView2); //textView2를 str2로 불러옴
        chestBtn = (Button) findViewById(R.id.chestBtn); //chestBtn을 불러옴
        str2.setVisibility(View.VISIBLE); //str2를 보이게 설정
        if (data.lightoff) { //불이 꺼져있을 경우
            str2.setText("어두워서 잘 안 보인다."); //str2의 텍스트를 위와 같이 설정
            str2.setOnClickListener(new View.OnClickListener() { //str2 클릭시 str2를 제거
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        } else if (data.haveMemo) { //불이 켜져있고 Memo 아이템을 가지고 있을 경우
            str2.setText("메모 말곤 더 없다."); //str2의 텍스트를 위와 같이 설정
            str2.setOnClickListener(new View.OnClickListener() {//str2 클릭시 str2를 제거
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        } else if (data.haveKey) { //불이 켜져있고 Memo 아이템이 없고, Key 아이템을 갖고 있을 경우
            str2.setText("메모를 획득했다."); //str2의 텍스트를 위와 같이 설정
            chestBtn.setBackgroundResource(R.drawable.chest_open); //chestBtn의 이미지를 chest_open으로 변경
            data.haveKey = false; //열쇠 아이템을 사용했으므로, 열쇠를 갖고 있지 않은것으로 설정
            data.haveMemo = true; //memo 아이템을 획득했으므로, true 로 변경
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                } //str2 클릭시 str2를 제거
            });
        } else { //불이 켜져있고, memo아이템이 없고, key아이템이 없을 경우
            str2.setText("상자는 잠겨있다");//str2의 텍스트를 위와 같이 설정
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }//str2 클릭시 str2를 제거
            });
        }
    }

    public void onKeyBtn(View view) { //keyBtn 클릭시 실행되는 코드
        str2 = (TextView) findViewById(R.id.textView2);
        keyBtn = (Button) findViewById(R.id.keyBtn);
        str2.setVisibility(View.VISIBLE);
        if (data.lightoff) {
            str2.setText("어두워서 잘 안 보인다.");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                } //위 함수와 동일
            });
        } else { //불이 켜져 있을 경우
            str2.setText("열쇠를 획득하였다."); //str2의 텍스트를 위와 같이 설정
            keyBtn.setVisibility(View.GONE); // keyBtn을 제거
            data.haveKey = true; //key 아이템을 획득 했으므로 true로 설정
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }//str2 클릭시 str2를 제거
            });
        }
    }

    public void onInBtn(View view) { //인벤토리 버튼 클릭시
        Intent intent = new Intent(Stage1.this, Inventory.class);
        startActivity(intent); //Inventory layout을 화면에 띄움
    }

    @Override
    public void onBackPressed() {
        return; //안드로이드 백버튼 막기
    }

    public void onLight(View view) {
        Button fire_point = (Button) findViewById(R.id.fire_point); //횃불 위치를 알려주는 빨간 점
        str2 = (TextView) findViewById(R.id.textView2);
        TextView img = (TextView) findViewById(R.id.light); //화면에 보이는 검은배경의 텍스트뷰로 화면을 어둡게 보이게 하는 역할
        if (data.lightoff) { //불이 꺼져있을경우
            fire_point.setVisibility(View.GONE); //빨간 점을 제거
            str2.setVisibility(View.VISIBLE); //str2를 보이게 설정
            str2.setText("횃불에 불을 켰다.");//str2의 텍스트를 위와 같이 설정
            ImageView fire = (ImageView) findViewById(R.id.flame); //fire 이미지뷰를 불러옴
            fire.setVisibility(View.VISIBLE);//fire 이미지뷰를 보이게 설정
            AnimationDrawable ani = (AnimationDrawable) fire.getDrawable(); //fire 이미지뷰에 설정된 애니메이션을 불러옴
            ani.start(); // 애니메이션 재생
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                } //str2 클릭시 str2 제거
            });
            img.setVisibility(View.GONE); //화면에 보이던 검은 배경을 제거, 불이 켜지는 연출
            data.lightoff = false; //불이 켜졌으므로 false로 변경

        } else { //불이 켜져있을 경우
            str2.setText("횃불이 잘 타고있다."); //str2의 텍스트를 위와 같이 설정
            str2.setVisibility(View.VISIBLE); //str2를 보이게 설정
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                } //str2 클릭시 str2 제거
            });
        }
    }

    public void onDoorBtn(View view) { //Door button 클릭시 실행
        str2 = (TextView) findViewById(R.id.textView2);
        str2.setVisibility(View.VISIBLE);
        Button yes = (Button) findViewById(R.id.yes);
        Button no = (Button) findViewById(R.id.no);
        if (data.lightoff) { //불이 꺼져있을 경우, 다른 on*Btn 함수와 동일
            str2.setText("어두워서 잘 안 보인다.");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
        else if (data.haveUpSword){ //불이 켜져있고 UpSword 아이템을 갖고 있을 시 실행
            str2.setText("알수없는 힘이 나를 끌어당긴다. 들어가 볼까?"); //str2의 텍스트를 다음과 같이 설정
            yes.setVisibility(View.VISIBLE);
            no.setVisibility(View.VISIBLE); // Yes와 No 버튼을 보이게 설정함
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    yes.setVisibility(View.GONE);
                    no.setVisibility(View.GONE);
                    str2.setVisibility(View.GONE); //str2를 클릭시 Yes,No 버튼, str2를 제거
                }
            });
        }
        else { //불이 꺼져있고 UpSword 아이템이 없을 경우
            str2.setText("<System 접근 불가 @0#$1%@> \n<#$#의 권한 부족 #01#0권한 필#@$>"); //str2의 텍스트를 다음과 같이 설정
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }//str2 클릭시 str2 제거
            });
        }
    }

    public void onPassWordBtn(View view) { //password button 클릭시 실행
        str2 = (TextView) findViewById(R.id.textView2);
        if (data.lightoff) { //불이 꺼져있을 경우, 다른 on*Btn 함수와 동일
            str2.setVisibility(View.VISIBLE);
            str2.setText("어두워서 잘 안 보인다.");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
        else { //불이 켜져있을 경우
            Intent intent = new Intent(Stage1.this, password.class);
            startActivity(intent); //password layout을 띄움
        }
    }
    public void onMemoBtn(View view){ //Memo button을 클릭시 실행
        str2 = findViewById(R.id.textView2);
        if (data.lightoff) { //불이 꺼져있을 경우, 다른 on*Btn 함수와 동일
            str2.setText("어두워서 잘 안 보인다.");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
        else{ //불이 켜져있을경우
                memoDialog m = new memoDialog(this); //memoDialog 객체 생성, 자세한 설명은 memoDialog.java 참조
                m.show(); //m을 화면에 띄움
            }
    }
    public void onNPCBtn(View view) { //npc 클릭시 실행
        str2 = (TextView) findViewById(R.id.textView2);
        EditText ed = (EditText) findViewById(R.id.hello); //입력을 받는 text 생성
        if (data.lightoff) { //불이 꺼져있을 경우, 출력되는 텍스트만 다르고 다른 on**Btn 함수와 동ㅇㄹ
            str2.setVisibility(View.VISIBLE);
            str2.setText("\\xea\\xb1\\xb0\\xea\\xb8\\xb0 \\xeb\\x88\\x84\\xea\\xb5\\xac \\xec\\x9e\\x88\\xec\\x96\\xb4?\\xec\\x95\\x9e\\xec\\x9d\\xb4 \\xec\\x95\\x88\\xeb\\xb3\\xb4\\xec\\x9d\\xb4\\xeb\\x84\\xa4");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
        else if (data.haveUpSword){ //불이 켜져있고 강화된 검을 갖고 있을 시 실행
            str2.setVisibility(View.VISIBLE);
            str2.setText("살려줘,이세계,그만해,결국,도와줘,창조주에,죽이지마,의해,그만둬,멸망,제발,영원히,누가좀,삭제될,멈춰줘,운명,그만,마법사와,괴로워,용사,고통스러워,세계를,멈춰,복구할수,부탁해,없어,아파,이세계를,어지러워,포기해라");
        }//다음과 같은 텍스트 출력
        else {
            if (s.equals(data.utfHello)) { //이전에 입력했던 s가s가 정답과 일치할 경우
                Intent intent = new Intent(Stage1.this, npc.class);
                startActivity(intent); //npc layout을 화면에 띄움
            }
            else { //이전에 입력했던 s가 정답과 일치하지 않을경우, 혹은 이전에 입력한적이 없는 경우
                str2.setVisibility(View.VISIBLE);
                str2.setText("안녕?");
                ed.setVisibility(View.VISIBLE); //ed를 보이게해 입력을 받게함
                str2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = ed.getText().toString(); //입력 받은 텍스트를 s에 저장
                        ed.setVisibility(View.GONE); //ed를 제거
                        if (s.equals(data.utfHello)) { //s가 정답과 일치할 경우 다음과 같은 텍스트 출력
                            str2.setText("반가워 아이템 강화나 분해를 도와줄게 \n\\xec\\x95\\x84\\xec\\x9d\\xb4\\xed\\x85\\x9c\\xec\\x9d\\x84 \\xeb\\xb3\\xb4\\xec\\x97\\xac\\xec\\xa4\\x98");
                            str2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    str2.setVisibility(View.GONE);
                                }//str2 클릭시 str2 제거
                            });
                        } else { //s가 정답이 아닐경우 다음과 같은 텍스트 출력
                            str2.setText("외국인인가? \n말이 안통하면 도와줄 수 없어.\n\\xec\\x9a\\xb0\\xeb\\xa6\\xac\\xeb\\xa7\\x90\\xeb\\xa1\\x9c\\xed\\x95\\xb4\\xeb\\xb4\\x90");
                            str2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    str2.setVisibility(View.GONE);//str2 클릭시 str2 제거
                                    ed.setText("");//ed의 텍스트를 초기화 시킴
                                }
                            });
                        }
                    }
                });
            }
        }
    }
    public void onYes(View view){ //Yes Button 클릭시 현재 Stage를 끝내고 Stage0를 띄움
        Intent intent = new Intent(this,Stage0.class);
        startActivity(intent);
        finish();
    }
    public void onNo(View view){ //No button 클릭시 yes,no button, str2를 제거
        Button yes = (Button) findViewById(R.id.yes);
        Button no = (Button) findViewById(R.id.no);
        yes.setVisibility(View.GONE);
        no.setVisibility(View.GONE);
        str2 = (TextView) findViewById(R.id.textView2);
        str2.setVisibility(View.GONE);
    }
    }

