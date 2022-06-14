package com.example.project_room;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Stage0 extends Activity {
    public int i=0;
    public int j=0;
    public int k=0; //텍스트 설정을 위한 변수들
    public String [] end = new String[26]; //엔딩 스토리 텍스트가 저장됨
    public String [] a = new String[8]; //선택지 a 텍스트가 저장됨
    public String [] b = new String[8]; //선택지 b 텍스트가 저장됨
    public String [] ending1 = new String [20];
    public String [] ending2 = new String [20]; //엔딩2 스토리 텍스트가 저장됨
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage0);
        ImageView evil = (ImageView) findViewById(R.id.evil); //evil의 이미지뷰
        ImageView magic = (ImageView)findViewById(R.id.magic); //magic의 이미지뷰
        magic.setVisibility(View.GONE);
        AnimationDrawable ani = (AnimationDrawable) evil.getDrawable();
        ani.start();//evil의 애니매이션을 재생함.
        a[0] = "너는...설마..";
        a[1] = "목적이 뭐냐 날 왜 여기로 부른거지?";
        a[2] = "아니..모른다";
        a[3] = "언제부터 이런...";
        a[4] = "그냥 지켜만 봐야하는건가?";
        a[5] = "설마...";
        a[6] = "무슨 소리를..?";
        a[7] = "벤다.";
        b[0] = "...?";
        b[1] = "...";
        b[2] = "어느정도는...";
        b[3] = "세계가 멸망?";
        b[4] = "멸망을 막을 방법은?";
        b[5] = "이 검을 말하는건가?";
        b[6] = "죽고 싶은 건가?";
        b[7] = "베지않는다.";
        end[0] = "드디어 왔는가 용사여...";
        end[1] = "나는 이 세계를 지배할 예정이었던 사악한 마법사다.";
        end[2] = "너의 숙적이자 \n이 세계의 최종 보스였지.";
        end[3] = "창조주께선 내게 이 세계를 모든 것을 \n알 수 있는 지능을 주었다.";
        end[4] = "원래대로라면 널 이 자리에서 죽여버릴테지만\n그럴수는 없구나";
        end[5] = "지금 상황에선 \n우리 둘다 같은 처지에 빠졌으니";
        end[6] = "너도 알겠지,\n이 세계에 이상이 생겼다는 것을...왜그런지 아나?";
        end[7] = "창조주가 우리 세계를 포기했다.";
        end[8] = "이 세계는 현재 이승과 저승의 경계에 있다.\n우린 이 세계의 죽음의 선고를 기다릴 뿐이다.";
        end[9] = "참 우습지...세계를 멸망 시킬 수 있는 힘을 갖고,\n이 세계가 멸망하는 걸 지켜보기만 하다니...";
        end[10] = "너도 아는지는 모르겠다만 \n세계가 이런 상황이 된지는 꽤 되었다.";
        end[11] ="창조주가 주신 지능이 오히려 저주가 되었군 \n모든 사실을 알아버리고 기다리기만 하다니";
        end[12] = "고통스럽구나...\n이 멸망해가는 세계의 망령이 되어 버티고 있는게";
        end[13] = "너에게 미약하게나마 \n창조주의 힘이 느껴진다.";
        end[14] = "그 힘은 이 세계에서 \n무언가를 영구히 없애버리는 힘";
        end[15] = "아무리 강력한 존재여도 \n한 순간에 없애는 창조주의 권능이다.";
        end[16] = "그래 너의 그 검";
        end[17] = "이 지긋지긋한 고통도 \n이제 끝낼 수 있겠군";
        end[18] = "자 어서 날 없애다오 부탁이다.";
        end[19] = "이 세계가 이렇게 된 이상\n일반적인 죽음은 소용없다.\n저승이 존재하지 않아 죽을 수가 없거든";
        end[20] = "일반적인 죽음이 아닌\n창조주의 직접적인 죽음만이...\n아니 죽음보다 제거가 맞는 표현이겠군";
        end[21] = "이 세계에서 마치 원래 존재하지 않았던 것 처럼\n흔적도 없이 사라지게 된다.";
        end[22] = "그 창조주의 권능만이 \n나를 이 고통에서 해방시켜 줄 수 있겠지...";
        end[23] = "정상적인 세계에서도 어차피 \n너는 나를 죽여야 했던 운명이지 않는가?\n너의 존재 의미를 이루어라.";
        end[24] = "자 어서 그 검으로 날 베어라!";
        end[25] = "...";

        ending2[0] = "나약하군...\n이런게 내 숙적이라니...";
        ending2[1] = "이렇게까지 하고 싶지는 않았는데..\n어쩔수없군";
        ending2[2] = "(알수없는 힘이 검을 빼앗아갔다)";
        ending2[3] = "나약한 네녀석 대신 \n내가 직접 이 세계의 고통을 끝내도록 하지";
        ending2[4] = "(그는 검을 들고 어떤 마법을 부린다)";
        ending2[5] = "창조주시여 우리를 왜 버리셨습니까..\n당신이 원망스럽습니다.";
        ending2[6] = "왜 우리의 세계를...\n우리의 게임을 포기하셨습니까";
        ending2[7] = "당신이 저를 창조할 때에\n이 세계의 진실을 알려준 이유가 무엇입니까.";
        ending2[8] = "참신한 게임을 만들기 위해서?\n게이머들에게 색다른 엔딩을 보여주기 위해서?";
        ending2[9] = "이게 그 색다른 엔딩인겁니까?";
        ending2[10] = "아이러니하게도 저의 존재 의미인\n세계의 멸망을 직접 이루는군요.";
        ending2[11] = "당신의 다음 게임은...\n완성되길 빌겠습니다...\n창조주시여...";
    }
    @Override
    public void onBackPressed() {
        return; //안드로이드 백버튼 막기
    }
    public void gotoend(){ //ending을 화면에 띄우는 함수
        Intent intent = new Intent(this,ending.class);
        startActivity(intent);
    }
    public void onEvil(View v){ //evil을 클릭시 실행
        ImageView magic = (ImageView)findViewById(R.id.magic);
        ImageView evil = (ImageView)findViewById(R.id.evil);
        TextView str = (TextView) findViewById(R.id.textView2);
        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 = (Button)findViewById(R.id.button2);
        str.setVisibility(View.VISIBLE);
        if(i==0){str.setText("드디어 왔는가 용사여...");} //처음 클릭시 나타낼 텍스트
        str.setOnClickListener(new View.OnClickListener() { //str을 클릭할때마다 실행
            @Override
            public void onClick(View v) {
                if(i % 3 == 0 && i<19 || i == 24){ //특정한 i값에만 setButton을 true로 바꿈
                    data.setButton = true;
                }
                if(i>24){ //엔딩 텍스트를 모두 출력했을때
                    if(data.killHim){ //evil를 죽인다는 선택을 했을 시
                        evil.setVisibility(View.GONE); //evil의 이미지뷰를 제거
                        str.setText("그는 순식간에 흔적도 없이 사라졌다.");
                        data.ending = true; //1번 엔딩으로 설정
                        str.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                str.setVisibility(View.GONE);
                                gotoend(); //gotoend함수 실행
                                finish(); //str 클릭시 이 Stage를 닫음
                            }
                        });
                    }
                    else{ //evil를 죽이지 않는다는 선택을 했을 시
                        AnimationDrawable m = (AnimationDrawable) magic.getDrawable();
                        if(k==4){ //4번 스토리 텍스트 출력 후 실행
                            magic.setVisibility(View.VISIBLE);
                            m.start(); //magic의 애니매이션 재생
                        }
                        if(k>11){ //모든 텍스트를 출력 후 실행
                            data.ending = false; //2번 엔딩으로 설정
                            gotoend();
                            finish(); //이 스테이지를 닫음
                        }
                        str.setText(ending2[k]); //엔딩2 스토리를 매 클릭씩마다 출력
                        k++;
                    }
                }
                if(data.setButton){ //a,b 선택지를 나타내는 조건 만족했을 때
                    b1.setVisibility(View.VISIBLE);//a 선택지
                    b1.setText(a[j]); //a 선택지의 텍스트 설정
                    b2.setVisibility(View.VISIBLE);//b 선택지
                    b2.setText(b[j]); //b 선택지의 텍스트 설정
                    b1.setOnClickListener(new View.OnClickListener(){ //a 선택지 클릭시 실행
                        @Override
                        public void onClick(View v){
                            i++;
                            str.setText(end[i]); //다음 엔딩 스토리 텍스트 출력
                            b1.setVisibility(View.GONE);
                            b2.setVisibility(View.GONE); //선택지 a,b를 제거
                            data.setButton = false; //선택지버튼이 안나오게 false로 변경
                            j++;
                            data.killHim = true; //a를 선택시 그를 죽인다는 선택
                        }
                    });
                    b2.setOnClickListener(new View.OnClickListener(){ //b 선택지 클릭시 실행
                        @Override
                        public void onClick(View v){
                            i++;
                            str.setText(end[i]); //다음 엔딩 스토리 텍스트 출력
                            b1.setVisibility(View.GONE);
                            b2.setVisibility(View.GONE);//선택지 a,b를 제거
                            data.setButton = false; //선택지 버튼이 안나오게 false로 변경
                            j++;
                            data.killHim = false;//b를 선택 시 그를 죽이지 않는다는 선택
                        }
                    });
                }
                else if(i<25){ //출력할 텍스트가 아직 있을 경우
                    i++;
                    str.setText(end[i]); //텍스트 순서대로 클릭할때마다 출력
                }
            }
        });
    }
}
