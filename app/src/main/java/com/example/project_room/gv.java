package com.example.project_room;

import android.app.Application;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;
import java.io.InputStream;
import java.util.Scanner;

public class gv extends Application {
    public static TextView tv;
    public static InputStream is;
    public static Scanner sc;
    public static SharedPreferences sf = null;
    public static SharedPreferences.Editor editor = null;
    public static void viewText() {
        gv.sc = new Scanner(gv.is,"UTF-8");
        String ch = gv.sc.nextLine();
        gv.tv.setText(ch);
        gv.tv.setVisibility(View.VISIBLE);
    }
}
