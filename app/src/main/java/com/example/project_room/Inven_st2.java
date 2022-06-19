package com.example.project_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

import androidx.core.content.ContextCompat;

public class Inven_st2 extends Activity { //Stage 2의 인벤토리(아이템창)
    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.inventory);

        mListView = (ListView)findViewById(R.id.listView);
        dataSetting();
    }
    private void dataSetting(){
        ItemAdapter adapter = new ItemAdapter();
        if (data.haveSword){ //검을 갖고있을 시 검 이미지와 다음 name,contents를 나타내는 데이터 adapter에 추가
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.sword),"검","평범한 검이다.");
        }
        if (data.st2_memory){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.memory),"00", "망자를 살려내며 너를 웃게하고, 젊게 만들어주며, 찰나에 태어나지만, 평생 지속되는 것");
        }
        if (data.st2_old){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.old),"00", "원하지 않더라도 너를 갉아 먹으며, 점점 더 힘들게 만드는 것");
        }
        if (data.st2_life){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.life),"0", "찬란한 순간이며 그 누구도 함부로 할 수 없으며 모든 생명체가 가질 수 있는 특권");
        }
        if (data.st2_death){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.death),"00", "몇몇은 숨으려 하며 몇몇은 속이려 하지만, 시간이 지나면 반드시 만나야 하는 존재, 그 이름을 맞춰라, 네가 소환 될 때가 오면 반듯이 알게 된다.");
        }
        if (data.st2_key1){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.key),"기억의 키", "00의 기억의 키.");
        }
        if (data.st2_key2){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.key),"늙음의 키", "00의 늙음의 키.");
        }
        if(data.st2_key3){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.key),"삶의 키","00의 삶의 키.");
        }
        if(data.st2_key4){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.key),"죽음의 키","00의 죽음의 키.");
        }
        mListView.setAdapter(adapter);

    }
    public void onExitBtn(View view){
        finish();
    }
}
