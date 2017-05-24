package com.study.lifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // 내가 생성한 액티비티 실행하고 결과 받아오기
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                Log.d("study", "Main onClick");

                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                // startActivity(intent);
                // 결과를 받으려면 다음과 괕이 인텐트를 호출해야 한다.
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(getApplicationContext(),
                "onActivityResult() 호출됨", Toast.LENGTH_SHORT).show();
        Log.d("study", "onAcitivityResult() 호출됨");
    }
}
