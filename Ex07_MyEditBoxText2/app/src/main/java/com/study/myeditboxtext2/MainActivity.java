package com.study.myeditboxtext2;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    EditText inputMessage;
    String strAmount = ""; // 임시저장값 (콤마)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        inputMessage = (EditText)findViewById(R.id.inputMessage);

        // inputMessage.setInputType(InputType.TYPE_CLASS_NUMBER); // 숫자만
        inputMessage.addTextChangedListener(watcher);
    }

    TextWatcher watcher = new TextWatcher()
    {
        public void onTextChanged(CharSequence str, int start, int before, int count)
        {
            Log.d("study", str.toString() + ":" + strAmount);
            if(!str.toString().equals(strAmount)) //StackOverflow를 막기위해,
            {
                strAmount = makeStringComma(str.toString().replace(",", ""));
                inputMessage.setText(strAmount);
                inputMessage.setSelection(inputMessage.getText().length());
            }
        }

        public void beforeTextChanged(CharSequence str, int start, int count, int after)
        {
            strAmount = str.toString();
        }

        public void afterTextChanged(Editable strEditable) {

        }
    };

    protected String makeStringComma(String str)
    {
        if (str.length() == 0)
        {
            return "";
        }
        long value = Long.parseLong(str);
        DecimalFormat format = new DecimalFormat("###,##0");
        return format.format(value);
    }
}
