package com.example.project_room;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class memoDialog extends Dialog implements OnClickListener { //Dialog형식으로 화면 전체가아닌 실행되고있는 layout 위에 창모드 처럼 띄움
    ImageView im;
    public memoDialog(Context context){
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //title 안보이게 함
        setContentView(R.layout.utfcode);
        im = (ImageView) findViewById(R.id.utfImg); //utfImg imageView im에 불러오기
        im.setOnClickListener(this);
    }
    public void onClick(View v){
        dismiss();
    } //클릭시 닫기
}
