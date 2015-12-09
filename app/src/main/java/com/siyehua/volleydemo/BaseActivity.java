package com.siyehua.volleydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void startRequest(String url, String parmas) {
        NetWorkUtils.getInstance().startRequest(url, parmas, new NetWorkUtils.GetDataListener() {
            @Override
            public void getDataSuccess(String requestId, String result) {
                BaseActivity.this.getDataSuccess(requestId, result);
            }

            @Override
            public void getDataError(String requestId, String result) {
                BaseActivity.this.getDataError(requestId, result);
            }
        });
    }

    protected abstract void getDataSuccess(String requestId, String result);

    protected abstract void getDataError(String requestId, String result);
}
