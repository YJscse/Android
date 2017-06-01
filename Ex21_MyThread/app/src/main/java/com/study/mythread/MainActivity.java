package com.study.mythread;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

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
                textView1.setText("RequestThread .. " + i);
            }
        }
    }
}
