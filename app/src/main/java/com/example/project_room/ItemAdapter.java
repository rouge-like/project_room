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

public class ItemAdapter extends BaseAdapter {
    private ArrayList<MyItem> mItems = new ArrayList<>();
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
    }
    public void addItem(Drawable img, String name,String contents){
        MyItem mItem = new MyItem();

        mItem.setIcon(img);
        mItem.setName(name);
        mItem.setContents(contents);
        mItems.add(mItem);
    }

}
