package com.study.myimageview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends Activity {

    ScrollView scrollView01;

    ImageView imageView01;
    ImageView imageView02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // 이미지 뷰
        imageView01 = (ImageView)findViewById(R.id.imageView01);
        imageView02 = (ImageView)findViewById(R.id.imageView02);

        imageView01.setImageResource(R.mipmap.background);
        imageView02.setImageResource(0);

        imageView01.invalidate();
        imageView02.invalidate();

        // 스크롤 바의 유무만 달라질 뿐, 실제로 스크롤읂 ㅏㄴ다.
        scrollView01 = (ScrollView)findViewById(R.id.scrollView01);
        scrollView01.setVerticalScrollBarEnabled(true);
        scrollView01.setHorizontalScrollBarEnabled(true);

        // 이미지 바꾸기 Down 버튼
        Button btnDown = (Button)findViewById(R.id.button01);
        btnDown.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                imageDown();
            }
        });

        // 이미지 바꾸기 Up 버튼
        Button btnUp = (Button)findViewById(R.id.button02);
        btnUp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                imageUp();
            }
        });
    }

    private void imageDown(){
        imageView01.setImageResource(0);
        imageView02.setImageResource(R.mipmap.background);

        imageView01.invalidate();
        imageView02.invalidate();
    }

    private void imageUp(){
        imageView01.setImageResource(R.mipmap.background);
        imageView02.setImageResource(0);

        imageView01.invalidate();
        imageView02.invalidate();
    }
}
