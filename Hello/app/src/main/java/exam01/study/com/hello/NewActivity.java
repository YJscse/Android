package exam01.study.com.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        // 인텐트에 전달된 데이타 구하기
        Intent intent = getIntent();
        final String sName = intent.getStringExtra("CustomerName");

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "CustomerName : " + sName, Toast.LENGTH_SHORT).show();
            }
        });

        // 인텐트 종료하기
        // 홈으로가기 버튼에 넣으면 된다 finish()를 넣으면 첫화면으로 넘어가기때문문
       Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 현재 인텐트 종료시 인텐트에 전달할 데이터 세팅
                Intent intent = new Intent();
                intent.putExtra("BackData", "강감찬");
                setResult(10, intent);

                finish();
            }
        });
    }
}
