package com.example.project_room;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class Stage0 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stage0);
        ImageView evil = (ImageView) findViewById(R.id.evil);
        AnimationDrawable ani = (AnimationDrawable) evil.getDrawable();
    }
}
