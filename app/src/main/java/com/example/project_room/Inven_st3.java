package com.example.project_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

import androidx.core.content.ContextCompat;

public class Inven_st3 extends Activity { //Stage 3의 인벤토리(아이템창)
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
        if (data.st3_foundKey){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.key),"열쇠","어디에 쓰이는 열쇠지?");
        }
        if (data.st3_foundSword){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.sword),"검", "평범한 검이다.");
        }
        if(data.st3_foundBone){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.bone),"숫자가 적혀있는 뼈","\"1634\"라고 적혀 있다.");
        }
        mListView.setAdapter(adapter);

    }
    public void onExitBtn(View view){
        finish();
    }
}
