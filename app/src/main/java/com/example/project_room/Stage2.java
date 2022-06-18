package com.example.project_room;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Stage2 extends Activity {
    Button Statue1, Statue2, Statue3, Statue4, Door, Lock, inv, box1, box2, box3, box4;
    TextView str1, str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.stage2);

        Door = (Button) findViewById(R.id.LockBtn);
        Door.setVisibility(View.INVISIBLE); // 마지막 문 잠금장치는 처음에 안보이게 표현

        str1 = (TextView) findViewById(R.id.textView1);
        str1.setText("여긴 어디지..? 무슨 궁전의 입구 같은데..\n 저 석상들에 뭔가 있는 것 같다.");
        str1.setVisibility(View.VISIBLE);
        str1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1.setVisibility(View.GONE);
            }
        });

        str2 = (TextView) findViewById(R.id.textView2);

        Lock = (Button) findViewById(R.id.LockBtn); // 잠금장치를 눌렀을 때 반응
        Lock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.st2_key4){ //4개의 키를 획득했을 경우
                    Door.setVisibility(View.VISIBLE);
                    str2.setText("잠금장치가 풀렸다.");
                    str2.setVisibility(View.VISIBLE);
                    str2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Door.setVisibility(View.VISIBLE);
                            str2.setText("잠금장치가 풀었더니 문 옆에 마지막 잠금 장치가 보인다. 4개의 쪽지와 연관된 답을 입력하면 될 것 같다. \n Hint : 'ㅅㄹ'");
                            str2.setVisibility(View.VISIBLE);
                            str2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    str2.setVisibility(View.GONE);
                                }
                            });
                        }
                    });
                } else { // 잠금장치를 눌렀을 때 반응
                    str2.setText("잠겨있다.\n구멍이 4개인걸로 보아 열쇠가 4개 필요할 것 같다.");
                    str2.setVisibility(View.VISIBLE);
                    str2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            str2.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });

        Statue1 = (Button) findViewById(R.id.Statue1Btn); //첫번째 조각상
        Statue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str2.setText("석상에서 쪽지가 나왔다. ");
                str2.setVisibility(View.VISIBLE);
                str2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        str2.setVisibility(View.GONE);
                    }
                });
                Statue1.setVisibility(View.GONE);
                data.st2_memory = true;
            }
        });

        Statue2 = (Button) findViewById(R.id.Statue2Btn); //두번째 조각상
        Statue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str2.setText("석상에서 쪽지가 나왔다. ");
                str2.setVisibility(View.VISIBLE);
                str2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        str2.setVisibility(View.GONE);
                    }
                });
                Statue1.setVisibility(View.GONE);
                data.st2_old = true;
            }
        });

        Statue3 = (Button) findViewById(R.id.Statue3Btn); //세번째 조각상
        Statue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str2.setText("석상에서 쪽지가 나왔다. ");
                str2.setVisibility(View.VISIBLE);
                str2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        str2.setVisibility(View.GONE);
                    }
                });
                Statue1.setVisibility(View.GONE);
                data.st2_life = true;
            }
        });

        Statue4 = (Button) findViewById(R.id.Statue4Btn); // 네번째 조각상
        Statue4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                str2.setText("석상에서 쪽지가 나왔다. ");
                str2.setVisibility(View.VISIBLE);
                str2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        str2.setVisibility(View.GONE);
                    }
                });
                Statue1.setVisibility(View.GONE);
                data.st2_death = true;
            }
        });


        inv = (Button) findViewById(R.id.inventory); //인벤토리 버튼
        inv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Stage2.this, Inven_st2.class);
                startActivity(intent);
            }
        });

        Door = (Button) findViewById(R.id.DoorBtn);
        Door.setOnClickListener(new View.OnClickListener() { // 문에서 마지막 비밀번호를 입력하면 스테이지 클리어.
                                    @Override
                                    public void onClick(View view) {
                                        if (data.st2_Dooropened) {
                                            Intent intent = new Intent(Stage2.this, Stage_final.class);
                                            startActivity(intent);
                                            finish();
                                        } else { //문 반응 -> 문제와 힌트 -> 비밀번호 입력창으로 넘어감
                                            str2.setText("4개의 쪽지와 관련된 비밀번호를 입력하시오.\n Hint : 'ㅅㄹ', 'h____'");
                                            str2.setVisibility(View.VISIBLE);
                                            str2.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    str2.setVisibility(View.GONE);
                                                }
                                            });
                                            Intent intent = new Intent(Stage2.this, Door_puzzle.class);
                                            startActivity(intent);
                                        }
                                    }
                                });

        box1 = (Button) findViewById(R.id.box1); //첫번째 상자를 눌렀을 때 반응
        box1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.st2_box1opened) { //비밀번호를 입력하여 1번상자가 열린 경우
                    data.st2_key1 = true; //기억 열쇠 획득
                    str2.setText("기억 상자가 열렸다. 00의 기억 열쇠를 얻었다.");
                    str2.setVisibility(View.VISIBLE);
                    str2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            str2.setVisibility(View.GONE);
                        }
                    });
                } else { //첫번째 상자 반응, 첫번째 쪽지와 관련있는 비밀번호 퍼즐로 넘어감.
                    str2.setText("석상과 관련된 비밀번호를 입력하시오.");
                    str2.setVisibility(View.VISIBLE);
                    str2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            str2.setVisibility(View.GONE);
                        }
                    });
                    Intent intent = new Intent(Stage2.this, Statue1_puzzle.class);
                    startActivity(intent);
                }

            }
        });

        box2 = (Button) findViewById(R.id.box2); //두번째 상자를 눌렀을 때 반응
        box2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.st2_box2opened) { //비밀번호를 입력하여 2번상자가 열린 경우
                    data.st2_key2 = true; //늙음 열쇠 획득
                    str2.setText("늙음 상자가 열렸다. 00의 늙음 열쇠를 얻었다.");
                    str2.setVisibility(View.VISIBLE);
                    str2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            str2.setVisibility(View.GONE);
                        }
                    });
                } else { //두번째 상자 반응, 두번째 쪽지와 관련있는 비밀번호 퍼즐로 넘어감.
                    str2.setText("석상과 관련된 비밀번호를 입력하시오.");
                    str2.setVisibility(View.VISIBLE);
                    str2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            str2.setVisibility(View.GONE);
                        }
                    });
                    Intent intent = new Intent(Stage2.this, Statue2_puzzle.class);
                    startActivity(intent);
                }

            }
        });

        box3 = (Button) findViewById(R.id.box3); //세번째 상자를 눌렀을 때 반응
        box3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.st2_box3opened) { //비밀번호를 입력하여 3번상자가 열린 경우
                    data.st2_key3 = true; //삶의 열쇠 획득
                    str2.setText("삶의 상자가 열렸다. 00의 삶의 열쇠를 얻었다.");
                    str2.setVisibility(View.VISIBLE);
                    str2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            str2.setVisibility(View.GONE);
                        }
                    });
                } else { //세번째 상자 반응, 두번째 쪽지와 관련있는 비밀번호 퍼즐로 넘어감.
                    str2.setText("석상과 관련된 비밀번호를 입력하시오.");
                    str2.setVisibility(View.VISIBLE);
                    str2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            str2.setVisibility(View.GONE);
                        }
                    });
                    Intent intent = new Intent(Stage2.this, Statue3_puzzle.class);
                    startActivity(intent);
                }

            }
        });

        box4 = (Button) findViewById(R.id.box4); //네번째 상자를 눌렀을 때 반응
        box4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.st2_box4opened) { //비밀번호를 입력하여 4번상자가 열린 경우
                    data.st2_key4 = true; //죽음의 열쇠 획득
                    str2.setText("죽음의 상자가 열렸다. 00의 죽음의 열쇠를 얻었다.");
                    str2.setVisibility(View.VISIBLE);
                    str2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            str2.setVisibility(View.GONE);
                        }
                    });
                } else { //네번째 상자 반응, 두번째 쪽지와 관련있는 비밀번호 퍼즐로 넘어감.
                    str2.setText("석상과 관련된 비밀번호를 입력하시오.");
                    str2.setVisibility(View.VISIBLE);
                    str2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            str2.setVisibility(View.GONE);
                        }
                    });
                    Intent intent = new Intent(Stage2.this, Statue4_puzzle.class);
                    startActivity(intent);
                }

            }
        });
    }
}

