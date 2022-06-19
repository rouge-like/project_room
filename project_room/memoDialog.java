package com.example.project_room;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class memoDialog extends Dialog implements OnClickListener {
    ImageView im;
    public memoDialog(Context context){
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.utfcode);
        im = (ImageView) findViewById(R.id.utfImg);
        im.setOnClickListener(this);
    }
    public void onClick(View v){
        dismiss();
    }
}
