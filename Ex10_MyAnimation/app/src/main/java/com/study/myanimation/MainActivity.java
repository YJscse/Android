package com.study.myanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        imageView1 = (ImageView) findViewById(R.id.imageView1);

        // 뷰 애니메이션
        // 뷰 애니메이션은 끝나면 제자리로 이동한다.
        final Animation anim1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        final Animation anim2 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.size_change);
        final Animation anim3 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.change_alpha);

        // 좌표 이동 애니메이션
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                imageView1.startAnimation(anim1);
            }

        });

        // 크기 변화 애니메이션
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                imageView1.startAnimation(anim2);
            }

        });

        // 알파값 변화 애니메이션
        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                imageView1.startAnimation(anim3);
            }

        });
    }
}
