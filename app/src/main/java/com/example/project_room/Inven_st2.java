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
        if (data.st2_memory){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.memory),"00", "00의 설명.");
        }
        if (data.st2_old){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.old),"00", "00의 설명.");
        }
        if (data.st2_life){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.life),"0", "0의 설명.");
        }
        if (data.st2_death){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.death),"00", "00의 설명.");
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
