package com.example.project_room;

import android.app.Application;

public class data extends Application {
    public static Boolean haveKey = false;
    public static Boolean haveMemo = false;
    public static Boolean lightoff = true;
    public static Boolean haveKeyBoard = true; //디버그용 true 설정 추후에 false로 변경ㅁㅁ
    public static Boolean correctNum = false;
    public static Boolean haveEnchantStones = false;
    public static String passWordNum = "";
    public static String utfHello = "a"; //디버그용 임시 정답 "b'\\xec\\x95\\x88\\xeb\\x85\\x95'";
    public static String whatItem = "";
    public static int [] enchantStones = new int[2]; // 올바른 강화석일 경우 1, 틀리거나 중복된 강화석일 경우 0

}