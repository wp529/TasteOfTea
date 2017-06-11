package edu.pzhu.system;

import android.app.Application;
import android.content.Context;

import edu.pzhu.system.model.login.LoginBean;

public class MyApplication extends Application {
    private static Context ctx;
    public static String MID;
    public static LoginBean loginData;

    @Override
    public void onCreate() {
        super.onCreate();
        ctx = getApplicationContext();
    }

    public static Context getContext() {
        return ctx;
    }
}
