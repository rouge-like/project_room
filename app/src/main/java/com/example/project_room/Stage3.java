package com.example.project_room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Stage3 extends Activity {
    public String[] story = new String[2];
    public int i = 0;
    Button btn, portal, sword, monster, chest;
    TextView str1, str2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        story[0] = "문을 열었더니 또 이상한 곳으로 들어왔다.";
        story[1] = "여긴 어디지...?";

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.stage3);

        portal = (Button) findViewById(R.id.portal);
        portal.setVisibility(View.INVISIBLE);

        str1 = (TextView) findViewById(R.id.textView1);
        str1.setText("문을 열었더니 또 이상한 곳으로 들어왔다.\n여긴 어디지...?");
        str1.setVisibility(View.VISIBLE);
        str1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    str1.setVisibility(View.GONE);
            }
        });
    }

    public void onBtn(View view) {
        str2 = (TextView) findViewById(R.id.textView2);
        btn = (Button) findViewById(R.id.button);
        str2.setVisibility(View.VISIBLE);


        if (data.st3_onBtn) {
            str2.setText("버튼을 누르니 포털이 나타났다.\n들어가보자");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        } else if(data.st3_foundKey) {
            portal.setVisibility(View.VISIBLE);
            str2.setText("열쇠가 돌아간다!");
            data.st3_onBtn = true;
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    str2.setVisibility(View.GONE);
                }
            });
        } else {
            str2.setText("버튼이 작동하지 않는다.\n버튼을 작동시키려면 열쇠가 필요한 것 같다.");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
    }

    public void onSwordBtn(View view) {
        sword = (Button) findViewById(R.id.sword);
        str2 = (TextView) findViewById(R.id.textView2);
        str2.setText("검이 있다. 혹시 모르니 챙겨둬야 겠다.");
        str2.setVisibility(View.VISIBLE);
        str2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str2.setVisibility(View.GONE);
            }
        });

        sword.setVisibility(View.GONE);
    }

    public void onInBtn(View view) {
        Intent intent = new Intent(Stage3.this, Inven_st3.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        return; //안드로이드 백버튼 막기
    }

    public void onPortalBtn(View view) { //스테이지 클리어
        finish();
    } //수저

    public void onMonsterBtn(View view) {
        monster = (Button) findViewById(R.id.monster);
        str2 = (TextView) findViewById(R.id.textView2);
        if(data.st3_monsterDefeat) {
            data.st3_foundBone = true;
            str2.setText("숫자가 적혀 있는 뼈를 주웠다.\n\"1634\"\n무언가의 비밀번호인 듯 하다.");
            str2.setVisibility(View.VISIBLE);
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });

        } else if(data.st3_foundSword) {
            str2.setText("해골을 해치웠다.");
            str2.setVisibility(View.VISIBLE);
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
            data.st3_monsterDefeat = true;
            monster.setVisibility(View.GONE);
        } else {
            str2.setText("해골이다!\n팔에 무언가 적혀있다.");
            str2.setVisibility(View.VISIBLE);
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setText("팔에 적혀있는 것을 보려면 해골을 해치워야 할 거 같다.\n근처에 무기로 쓸만한 게 없을까?");
                    str2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            str2.setVisibility(View.GONE);
                        }
                    });
                }
            });
        }
    }

    public void onSafeBtn(View view) {
        str2 = (TextView) findViewById(R.id.textView2);
        str2.setText("비밀번호를 입력해야 금고를 열 수 있다.");
        str2.setVisibility(View.VISIBLE);
        str2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str2.setVisibility(View.GONE);
            }
        });

        Intent intent = new Intent(Stage3.this, st3_password.class);
        startActivity(intent);
    }
}
