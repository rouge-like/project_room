package com.example.project_room;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends BaseAdapter { //ListView에 아이템을 나타내기 위한 java파일

    private ArrayList<MyItem> mItems = new ArrayList<>(); //아이템들의 데이터가 저장된 list
    @Override
    public int getCount(){return mItems.size();}
    @Override
    public MyItem getItem(int position){return mItems.get(position);}
    @Override
    public long getItemId(int position){return 0;}
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Context context = parent.getContext();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_custom,parent,false);
        }
        ImageView iv_img = (ImageView) convertView.findViewById(R.id.iv_img);
        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tv_contents = (TextView) convertView.findViewById(R.id.tv_contents);
        MyItem myitem = getItem(position);

        iv_img.setImageDrawable(myitem.getIcon());
        tv_name.setText(myitem.getName());
        tv_contents.setText(myitem.getContents());

        return convertView;
    }//BaseAdapter 기본 함수들 셋팅, 실제로 사용하지는 않음
    public void addItem(Drawable img, String name,String contents){ //입력받은 데이터를 추가
        MyItem mItem = new MyItem();

        mItem.setIcon(img); //입력받은 icon을 mItem에 셋팅
        mItem.setName(name);//name셋팅
        mItem.setContents(contents); //contents셋팅
        mItems.add(mItem);//셋팅 완료된 mItem을 mItems 리스트에 추가
    }

}