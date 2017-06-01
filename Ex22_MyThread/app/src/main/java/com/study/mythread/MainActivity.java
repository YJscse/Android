package com.study.mythread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    TextView textView1;
    Handler handler;
    ProgressBar progressBar1;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        handler = new Handler();

        textView1 = (TextView)findViewById(R.id.textView1);
        progressBar1 = (ProgressBar)findViewById(R.id.progressBar1);

        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                button1.setEnabled(false);

                RequestThread thread = new RequestThread();
                thread.start();
            }
        });

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),
                        "쓰레드 테스트",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    class RequestThread extends Thread{
        public void run() {
            for(int i = 0; i < 100; i++) {
                //Log.d("study", "Request Thread .. " + i);

                // 별도의 핸들러 클래스를 만들지 않고 바로 처리한다.
                // 앞의 예제처럼 핸들러 바깥의 변수와 안쪽의 변수를 공유할 수 없다.
                final int index = i;
                handler.post(new Runnable(){

                    @Override
                    public void run() {
                        if(index == 0) {
                            progressBar1.setProgress(0);
                        }

                        textView1.setText("Request Thread .. " + index);

                        progressBar1.incrementProgressBy(1);

                        if(index == 99) {
                            button1.setEnabled(true);
                        }
                    }
                });

                try {
                    Thread.sleep(100);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
