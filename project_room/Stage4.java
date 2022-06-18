package com.example.project_room;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Stage4 extends Activity {

    Button portal, planetR1, planetR2, planetR3, planetB, planetM;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage4);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        portal = (Button) findViewById(R.id.portal);
        planetR1 = (Button) findViewById(R.id.planetR1);
        planetR2 = (Button) findViewById(R.id.planetR2);
        planetR3 = (Button) findViewById(R.id.planetR3);
        planetB = (Button) findViewById(R.id.planetB);
        planetM = (Button) findViewById(R.id.planetM);

        data.st4_locate[0][0]=1;
        data.st4_locate[0][1]=1;
        data.st4_locate[2][0]=1;
        data.st4_locate[1][1]=1;
        data.st4_locate[4][1]=1;

    }

    public void onPlanetB(View view){
        int x = data.PB[0];
        int y = data.PB[1];
        if (x != 0){
            if (data.st4_locate[x-1][y] == 0){
                planetB.animate().apply {
                    duration = 1000
                }
            }
        }
    }
//파란 행성은 좌측으로, 붉은 행성은 우측으로, 달은 아래로 이동하는 형태로 프로그래밍 하려고 시도
//애니메이션을 넣는 기능과 함수들을 넣는 기능을 구현하지 못했습니다.
//가운데 길을 열어야 다음 단계로 넘어가는 맵을 구현하고싶었습니다.
}
