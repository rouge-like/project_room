package com.example.project_room;

import android.graphics.drawable.Drawable;

public class MyItem { //MyItem 클래스 각 요소들을 저장하고 반환함
    private Drawable icon; // 인벤토리에 나오는 이미지
    private String name,contents; //인벤토리에 나오는 아이템이름, 아이템설명

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}


