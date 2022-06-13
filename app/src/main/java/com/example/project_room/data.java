package com.example.project_room;

import android.app.Application;

public class data extends Application {
    public static Boolean haveKey = false;
    public static Boolean haveMemo = false;
    public static Boolean lightoff = true;
    public static Boolean haveKeyBoard = true; //디버그용 true 설정 추후에 false로 변경ㅁㅁ
    public static Boolean correctNum = false;
    public static Boolean haveEnchantStones = false;
    public static Boolean onEnchant = false;
    public static Boolean haveSword = true; //임시
    public static Boolean haveUpSword = false;
    public static boolean setButton = false;
    public static boolean killHim;
    public static boolean ending; //true일시 1번엔딩 false일시 2번엔딩
    public static String passWordNum = "";
    public static String utfHello = "a"; //디버그용 임시 정답 "\\xec\\x95\\x88\\xeb\\x85\\x95";
    public static String whatItem = "";
    public static int [] enchantStones = new int[2]; // 강화석을 선택 안했을 경우, 올바른 강화석일 경우 1, 틀리거나 중복된 강화석일 경우 2

    public static Boolean st3_safeOpened = false;
    public static Boolean st3_foundKey = false;
    public static Boolean st3_foundSword = false;
    public static Boolean st3_monsterDefeat = false;
    public static Boolean st3_foundBone = false;


}