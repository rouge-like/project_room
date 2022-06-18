package com.example.project_room;

import android.app.Application;

public class data extends Application { //게임 관련 데이터들을 저장하는 java파일
    public static Boolean haveKey = false; //key아이템을 갖고있으면 true, 없으면 false
    public static Boolean haveMemo = false; //memo 아이템을 갖고있으면 true, 없으면 false
    public static Boolean lightoff = true; //불이 꺼져잇으면 true, 켜져있으면 false
    public static Boolean haveKeyBoard = false; //keyBoard 아이템을 갖고있으면 true, 없으면 false;
    public static Boolean correctNum = false; //비밀번호를 맞춘적이 있을 경우 true, 아닐 경우 false;
    public static Boolean haveEnchantStones = false; //강화석을 갖고 있을 경우 true, 아닐경우 false
    public static Boolean onEnchant = false; //강화 선택 중일 경우 true, 아닐경우 false
    public static Boolean haveSword = true; //검 아이템을 갖고있으면 true, 없으면 false
    public static Boolean haveUpSword = false; // 강화된 검을 갖고 있으면 true, 없으면 false
    public static boolean setButton = false; //true일시 a,b선택지 버튼을 나타냄
    public static boolean killHim; //true일시 그를 죽인다는 선택, false일시 그를 죽이지 않는다는 선택
    public static boolean ending; //true일시 1번엔딩 false일시 2번엔딩
    public static String passWordNum = ""; //입력되고 있는 비밀번호
    public static String utfHello = "a";//"\\xec\\x95\\x88\\xeb\\x85\\x95"; //문자열 디코드 퍼즐의 정답
    public static String whatItem = ""; //npc창에서 선택되고 있는 아이템 이름
    public static int [] enchantStones = new int[2]; // 강화석을 선택 안했을 경우 0, 올바른 강화석일 경우 1, 틀리거나 중복된 강화석일 경우 2

    public static Boolean st3_safeOpened = false;
    public static Boolean st3_foundKey = false;
    public static Boolean st3_foundSword = false;
    public static Boolean st3_monsterDefeat = false;
    public static Boolean st3_foundBone = false;

    public static Boolean st2_key1 = false;
    public static Boolean st2_key2 = false;
    public static Boolean st2_key3 = false;
    public static Boolean st2_key4 = false;
    public static Boolean st2_memory = false;
    public static Boolean st2_old = false;
    public static Boolean st2_life = false;
    public static Boolean st2_death = false;
    public static Boolean st2_box1opened = false;
    public static Boolean st2_box2opened = false;
    public static Boolean st2_box3opened = false;
    public static Boolean st2_box4opened = false;
    public static Boolean st2_Dooropened = false;







}