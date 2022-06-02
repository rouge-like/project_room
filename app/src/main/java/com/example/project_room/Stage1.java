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
    public String[] story = new String[2];
    public int i = 0;
    public String s="안녕";
    byte [] b = s.getBytes(StandardCharsets.UTF_8);
    Button keyBtn, chestBtn;
    TextView str1, str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        story[0] = "너무 어둡다..잘 보이지 않는다.";
        story[1] = "주변에 횃불이 있을 것 같다 찾아보자.";
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.stage1);
        str1 = (TextView) findViewById(R.id.textView1);
        str1.setVisibility(View.VISIBLE);
        str1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < 2) {
                    str1.setText(story[i]);
                    i += 1;
                } else {
                    str1.setVisibility(View.GONE);
                }
            }
        });
    }
    public void onChestBtn(View view) {
        str2 = (TextView) findViewById(R.id.textView2);
        chestBtn = (Button) findViewById(R.id.chestBtn);
        str2.setVisibility(View.VISIBLE);
        if (data.lightoff) {
            str2.setText("어두워서 잘 안 보인다.");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        } else if (data.haveMemo) {
            str2.setText("메모 말곤 더 없다.");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        } else if (data.haveKey) {
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
        } else {
            str2.setText("상자는 잠겨있다");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
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
                }
            });
        } else {
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
    }

    public void onInBtn(View view) {
        Intent intent = new Intent(Stage1.this, Inventory.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        return; //안드로이드 백버튼 막기
    }

    public void onLight(View view) {
        str2 = (TextView) findViewById(R.id.textView2);
        TextView img = (TextView) findViewById(R.id.light);
        boolean b = !(data.lightoff);
        if (data.lightoff) {
            str2.setVisibility(View.VISIBLE);
            str2.setText("횃불에 불을 켰다.");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
            img.setVisibility(View.INVISIBLE);
            data.lightoff = false;

        } else if (b) {
            str2.setText("횃불이 잘 타고있다.");
            str2.setVisibility(View.VISIBLE);
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
    }

    public void onDoorBtn(View view) {
        str2 = (TextView) findViewById(R.id.textView2);
        str2.setVisibility(View.VISIBLE);
        Button yes = (Button) findViewById(R.id.yes);
        Button no = (Button) findViewById(R.id.no);
        if (data.lightoff) {
            str2.setText("어두워서 잘 안 보인다.");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
        else if (data.haveUpSword){
            str2.setText("알수없는 힘이 나를 끌어당긴다. 들어가 볼까?");
            yes.setVisibility(View.VISIBLE);
            no.setVisibility(View.VISIBLE);
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    yes.setVisibility(View.GONE);
                    no.setVisibility(View.GONE);
                    str2.setVisibility(View.GONE);
                }
            });
        }
        else {
            str2.setText("<System 접근 불가 @0#$1%@> \n<#$#의 권한 부족 #01#0권한 필#@$>");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
    }

    public void onPassWordBtn(View view) {
        str2 = (TextView) findViewById(R.id.textView2);
        if (data.lightoff) {
            str2.setVisibility(View.VISIBLE);
            str2.setText("어두워서 잘 안 보인다.");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
        else {
            Intent intent = new Intent(Stage1.this, password.class);
            startActivity(intent);
        }
    }
    public void onMemoBtn(View view){
        str2 = findViewById(R.id.textView2);
        if (data.lightoff) {
            str2.setText("어두워서 잘 안 보인다.");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
        else{
                memoDialog m = new memoDialog(this);
                m.show();
            }
    }
    public void onNPCBtn(View view) {
        str2 = (TextView) findViewById(R.id.textView2);
        EditText ed = (EditText) findViewById(R.id.hello);
        if (data.lightoff) {
            str2.setVisibility(View.VISIBLE);
            str2.setText("b'\\xea\\xb1\\xb0\\xea\\xb8\\xb0 \\xeb\\x88\\x84\\xea\\xb5\\xac \\xec\\x9e\\x88\\xec\\x96\\xb4?\\xec\\x95\\x9e\\xec\\x9d\\xb4 \\xec\\x95\\x88\\xeb\\xb3\\xb4\\xec\\x9d\\xb4\\xeb\\x84\\xa4'");
            str2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    str2.setVisibility(View.GONE);
                }
            });
        }
        else if (data.haveUpSword){
            str2.setVisibility(View.VISIBLE);
            str2.setText("살려줘,이세계,그만해,결국,도와줘,창조주에,죽이지마,의해,그만둬,멸망,제발,영원히,누가좀,삭제될,멈춰줘,운명,그만,마법사와,괴로워,용사,고통스러워,세계를,멈춰,복구할수,부탁해,없어,아파,이세계를,어지러워,포기해라");
        }
        else {
            if (s.equals(data.utfHello)) {
                Intent intent = new Intent(Stage1.this, npc.class);
                startActivity(intent);
            }
            else {
                str2.setVisibility(View.VISIBLE);
                str2.setText("안녕?");
                ed.setVisibility(View.VISIBLE);
                str2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        s = ed.getText().toString();
                        ed.setVisibility(View.GONE);
                        if (s.equals(data.utfHello)) {
                            str2.setText("반가워 아이템 강화나 분해를 도와줄게 \nb'\\xec\\x95\\x84\\xec\\x9d\\xb4\\xed\\x85\\x9c\\xec\\x9d\\x84 \\xeb\\xb3\\xb4\\xec\\x97\\xac\\xec\\xa4\\x98'");
                            str2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    str2.setVisibility(View.GONE);
                                }
                            });
                        } else {
                            str2.setText("외국인인가? \n말이 안통하면 도와줄 수 없어.\nb'\\xec\\x9a\\xb0\\xeb\\xa6\\xac\\xeb\\xa7\\x90\\xeb\\xa1\\x9c\\xed\\x95\\xb4\\xeb\\xb4\\x90'");
                            str2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    str2.setVisibility(View.GONE);
                                    ed.setText("");
                                }
                            });
                        }
                    }
                });
            }
        }
    }
    public void onYes(View view){
        Intent intent = new Intent(this,Stage0.class);
        startActivity(intent);
    }
    public void onNo(View view){
        Button yes = (Button) findViewById(R.id.yes);
        Button no = (Button) findViewById(R.id.no);
        yes.setVisibility(View.GONE);
        no.setVisibility(View.GONE);
        str2 = (TextView) findViewById(R.id.textView2);
        str2.setVisibility(View.GONE);
    }
    }

