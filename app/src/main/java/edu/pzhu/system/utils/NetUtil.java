package edu.pzhu.system.utils;


import android.content.Context;
import android.net.ConnectivityManager;

import edu.pzhu.system.MyApplication;

public class NetUtil {

    public static boolean isNetworkConnected() {
        boolean flag = false;
        //得到网络连接信息
        ConnectivityManager manager = (ConnectivityManager) MyApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        //去进行判断网络是否连接
        if (manager.getActiveNetworkInfo() != null) {
            flag = manager.getActiveNetworkInfo().isAvailable();
        }
        return flag;
    }
}
