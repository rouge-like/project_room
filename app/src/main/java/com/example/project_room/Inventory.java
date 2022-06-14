package com.example.project_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class Inventory extends Activity {
    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.inventory);

        mListView = (ListView)findViewById(R.id.listView); //inventory layout의 listView를 불러옴
        dataSetting();
    }
    private void dataSetting(){ //인벤토리에 나타낼 아이템 데이터들을 확인하고 나타냄
        ItemAdapter adapter = new ItemAdapter(); //ItemAdapter 객체 생성
        if (data.haveSword){ //검을 갖고있을 시 검 이미지와 다음 name,contents를 나타내는 데이터 adapter에 추가
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.sword),"검","평범한 검이다.");
        }
        if (data.haveKey){ //key 아이템을 갖고 있을 시 key이미지와 다음 name, contents를 나타내는 데이터 adapter에 추가
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.key),"열쇠","문에 쓰는 열쇠는 아닌듯하다.");
        }
        if (data.haveMemo){//위와 같음
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img),"메모","'4829'라고 적혀있다.");
        }
        if(data.haveKeyBoard){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.keyboard),"처음 보는 물건","키보드라고 불리는 것 같다.");
        }
        if (data.haveUpSword){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.sword_up),"+??? ???의 힘이 깃든 검","#01#0권한이 깃든 #$!@00");
        }
        mListView.setAdapter(adapter); //listView에 adpater를 추가함

    }
    public void onExitBtn(View view){
        finish();
    } //나가기 버튼 클릭시 종료

}
