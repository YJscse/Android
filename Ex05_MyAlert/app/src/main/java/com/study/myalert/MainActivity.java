package com.study.myalert;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.study.util.CustomProgressDialog;

public class MainActivity extends Activity {

    public static CustomProgressDialog progressDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        //버튼 1 : 기본형
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("알림")
                        .setMessage("아이디를 입력해 주세요")
                        .setCancelable(false)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("닫기", null)
                        .show();
            }
        });

        // 버튼 2 : 상단 없애고 내용만
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                new AlertDialog.Builder(MainActivity.this)
                        //.setTitle("알림")
                        .setMessage("아이디를 입력해 주세요")
                        .setCancelable(false)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("닫기", null)
                        .show();
            }
        });

        // 버튼 3 : 버튼 처리
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setMessage("앱을 종료하시겠습니까?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("알림")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog, int id){

                                Toast.makeText(getApplicationContext(), "ID value is " +
                                        Integer.toString(id), Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Toast.makeText(getApplicationContext(), "ID value is " +
                                        Integer.toString(id), Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }

                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });


        // 버튼 4 : 진행중 표시
        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
               if(progressDialog == null || !progressDialog.isShowing())
               {
                   progressDialog = CustomProgressDialog.show(MainActivity.this, "",
                           "처리중입니다", true, true, null);
               }
            }
        });
    }
}
