package com.example.project_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class password extends Activity { //password layout에 쓰이는 java파일
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //title이 안보이게 설정
        setContentView(R.layout.password);
    }
    public void input(View view){ //숫자 패드 클릭시 실행
        Button bt = (Button)findViewById(view.getId()); //클릭 된 숫자패드의 id를 불러옴
        TextView tv = (TextView) findViewById(R.id.password); //화면에 출력될 textView를 불러옴
        String n = data.passWordNum;  //passWordNum에 저장된 문자열을 불러옴
        if(bt.getId() == R.id.button1){ //1번 패드 클릭시 n에 1을 추가
            n += "1";
        }
        if(bt.getId() == R.id.button2){//2번 패드 클릭시 n에 2를 추가
            n += "2";
        }
        if(bt.getId() == R.id.button3){//3번 패드 클릭시 n에 3을 추가
            n += "3";
        }
        if(bt.getId() == R.id.button4){//위와 같음
            n += "4";
        }
        if(bt.getId() == R.id.button5){
            n += "5";
        }
        if(bt.getId() == R.id.button6){
            n += "6";
        }
        if(bt.getId() == R.id.button7){
            n += "7";
        }
        if(bt.getId() == R.id.button8){
            n += "8";
        }
        if(bt.getId() == R.id.button9){
            n += "9";
        }
        data.passWordNum = n; //passWordNum에 입력 받은 값을 저장
        tv.setText(n);//입력받은 값을 tv에 설정
    }
    public void oninputBtn(View view){ //입력 버튼을 클릭시
        TextView tv = (TextView)findViewById(R.id.password); //화면에 출력되고있는 textView
        if (tv.getText().equals("4829")) { //입력했던 비밀번호가 일치할경우
            if(data.correctNum == false) { //이전에 맞는 비밀번호를 입력한적이 없는 경우
                data.passWordNum = ""; //passWordNum을 초기화
                Toast.makeText(this, "<System.Correct.Number>\n<아이템 $#@! 제공 #$#에 사용>", Toast.LENGTH_SHORT).show(); //다음 텍스트를 화면 아래에 알림
                data.correctNum = true; //맞는 비밀번호를 입력 했으므로 true로 변경
                data.haveKeyBoard = true; // keyBoard 아이템 제공, true로 변경
                finish(); //현재 layout을 닫음
            }
            else{ //이전에 맞는 비밀번호를 입력한 적이 있을 경우
                Toast.makeText(this,"<System.#$#@.Num##$1>\n<오류 1@#*! 이미 적용된 @!#$>",Toast.LENGTH_SHORT).show(); //다음 텍스트를 화면 아래에 알림
                data.passWordNum = ""; //문자열 초기화
                tv.setText(data.passWordNum); //tv 텍스트를 초기화 시킴
            }
        }
        else{//비밀번호가 틀렸을 경우
            data.passWordNum = "";//문자열 초기화
            tv.setText(data.passWordNum); //텍스트 초기화
            Toast.makeText(this,"<System.Wron#@.Number>\n<재입력 $%$#>",Toast.LENGTH_SHORT).show();//다음 텍스트를 화면 아래에 알림
        }
    }
    public void onoutBtn(View view){ //닫기 버튼 클릭 시 실행
        data.passWordNum = ""; //passWordNum 문자열을 초기화 시키고
        finish(); //닫기
    }
}
