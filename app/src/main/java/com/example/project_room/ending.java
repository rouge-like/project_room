package com.example.project_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;


public class ending extends Activity {
    int i = 0;
    public String s = "";
    public String [] e = new String[6];
    public String [] d = new String[9];
    @Override
    protected void onCreate(Bundle savedInstanceState){
        e[0] = "엔딩 1";
        e[1] = "\n한달 후 한 개발자가 자신이 삭제한 게임을 복구시킨다.";
        e[2] = "\n\"이 게임 역시 포기하기엔 너무 아까워 다시 시작해보자\"";
        e[3] = "\n(Project_Rpg를 복원합니다)";
        e[4] = "\n\"어..? 뭔가 부족한데...최종보스 파일이 어디갔지?\"";
        e[5] = "\n<ending : 영구 삭제 된 최종보스>";
        d[0] = "엔딩 2";
        d[1] = "\n한달 후 한 개발자가 자신이 삭제한 게임을 복구시킨다.";
        d[2] = "\n\"이 게임 역시 포기하기엔 너무 아까워 다시 시작해보자\"";
        d[3] = "\n(휴지통에 Project_Rpg가 존재하지 않습니다)";
        d[4] = "\n\"어..? 왜 파일이 없지?이상하다...분명 영구삭제하지는 않았는데..";
        d[5] = "\n나도 모르게 휴지통을 비웠었나?";
        d[6] = "\n역시 그냥 포기해 버리는게 나을까..좀 아까운데";
        d[7] = "\n그래 다른 게임 개발에 집중하자\"";
        d[8] = "\n<ending : 사라진 게임>";
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.ending);
        super.onCreate(savedInstanceState);
        TextView str = (TextView) findViewById(R.id.textView3);
        if(data.ending){
            str.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(i>5){finish();}
                    else {
                        s += e[i];
                        str.setText(s);
                        i++;
                    }
                }
            });
        }
        else{
            str.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(i>8){finish();}
                    else {
                        s += d[i];
                        str.setText(s);
                        i++;
                    }
                }
            });
        }
    }
    @Override
    public void onBackPressed() {
        return; //안드로이드 백버튼 막기
    }
}
