package com.study.mythread02;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    TextView textView1;
    ProgressHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // 3: 추가한 클래스를 이용한 핸들러 변수 만들기
        handler = new ProgressHandler();


        textView1 = (TextView)findViewById(R.id.textView1);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                RequestThread thread = new RequestThread();
                thread.start();
            }
        });
    }

    class RequestThread extends Thread{
        public void run() {
            for(int i = 0; i < 20; i++) {
                //Log.d("gikimi", "Request Thread .. " + i);

                // 1. : 쓰레드에서 메인쓰레드의 객체로의 접근은 불가능
                //textView1.setText("RequestThread .. " + i);

                // 4 : 핸들러에 전달할 메시지 작성
                Message msg = handler.obtainMessage();

                Bundle bundle = new Bundle();
                bundle.putString("data", "Request Thread .. " + i);
                msg.setData(bundle);

                handler.sendMessage(msg);

                try {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    // 2 : 핸들러 클래스 생성
    class ProgressHandler extends Handler {

        @Override
        public void handleMessage(Message msg){

            // 5 : 핸들러에 메시지가 전달되면 원하는 동작 처리
            Bundle bundle = msg.getData();
            String data = bundle.getString("data");

            textView1.setText(data);
        }
    }
}
