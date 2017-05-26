package com.study.mysharedpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        SharedPreferences pref = getSharedPreferences("login", Activity.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        final EditText tvID = (EditText)findViewById(R.id.etID);
        final EditText tvPwd = (EditText)findViewById(R.id.etPwd);

        Button btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                String sid = tvID.getText().toString();
                String spwd = tvPwd.getText().toString();

                editor.putString("id", sid);
                editor.putString("pwd", spwd);
                editor.commit();
            }
        });

        String id = pref.getString("id", "");
        String pwd = pref.getString("pwd", "");

        Log.d("study", "id:"+id);

        tvID.setText(id);
        tvID.setSelection(tvID.length()); // 커서를 끝에 위치!
        tvPwd.setText(pwd);
    }
}
