package com.siyehua.volleydemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_startRequest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRequest("http://www.baidu.com", "");
                startRequest("http://www.haosou.com", "");
                startRequest("http://www.google.com", "");
            }
        });
    }


    @Override
    protected void getDataSuccess(String requestId, String result) {
        //switch different request
        if (requestId.equals("http://www.baidu.com")) {
            Toast.makeText(MainActivity.this, "baidu", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "haosou", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void getDataError(String requestId, String result) {
        Toast.makeText(MainActivity.this, requestId, Toast.LENGTH_SHORT).show();
    }
}
