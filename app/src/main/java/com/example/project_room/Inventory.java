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

        mListView = (ListView)findViewById(R.id.listView);
        dataSetting();
    }
    private void dataSetting(){
        ItemAdapter adapter = new ItemAdapter();
        if (data.haveSword){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.sword),"검","장식되어있는 평범한 검");
        }
        if (data.haveKey){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img),"열쇠","문에 쓰는 열쇠는 아닌듯하다.");
        }
        if (data.haveMemo){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.img),"메모","'4829'라고 적혀있다.");
        }
        if(data.haveKeyBoard){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.keyboard),"처음 보는 물건","키보드라고 불리는 것 같다.");
        }
        if (data.haveUpSword){
            adapter.addItem(ContextCompat.getDrawable(getApplicationContext(),R.drawable.sword_up),"+??? ???의 힘이 깃든 검","#01#0권한이 깃든 #$!@00");
        }
        mListView.setAdapter(adapter);

    }
    public void onExitBtn(View view){
        finish();
    }

}
