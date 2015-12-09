package com.siyehua.volleydemo;

import android.app.Application;

/**
 * Created by huangxk on 2015/12/9.
 */
public class SiApplication extends Application {
    private static SiApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static SiApplication getInstance() {
        return application;
    }
}
