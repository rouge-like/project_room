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
    public static String passWordNum = "";
    public static String utfHello = "a"; //디버그용 임시 정답 "b'\\xec\\x95\\x88\\xeb\\x85\\x95'";
    public static String whatItem = "";
    public static int [] enchantStones = new int[2]; // 강화석을 선택 안했을 경우, 올바른 강화석일 경우 1, 틀리거나 중복된 강화석일 경우 2

    public static Boolean st3_safeOpened = false;
    public static Boolean st3_foundKey = false;
    public static Boolean st3_foundSword = false;
    public static Boolean st3_monsterDefeat = false;
    public static Boolean st3_foundBone = false;

    public static int[][] st4_locate= new int[5][3];
    public static int[] PR1= {4,1};
    public static int[] PR2= {2,0};
    public static int[] PR3= {1,1};
    public static int[] PB= {0,1};
    public static int[] PM1= {1,0};
    public static int[] PM2= {0,2};


}