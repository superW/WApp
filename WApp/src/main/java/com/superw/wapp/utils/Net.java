package com.superw.wapp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

/**
 * 网络相关辅助类
 * Created by wangyc-e on 2015/12/23.
 */
public class Net {

    /**
     * 检查是否是数据连接
     * @param context
     * @return
     */
    public static boolean isMobileConnectivity(Context context) {
        // 获取手机网络连接管理器，可以获取到网络的连接类型，连接状态。
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    /**
     * 检查是否是WIFI连接
     * @param context
     * @return
     */
    public static boolean isWIFIConnectivity(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    /**
     * 判断网络：wifi、3G 是否可用
     *
     * @param inContext
     * @return
     */
    public static boolean isNetActive(Context inContext) {
        Context context = inContext.getApplicationContext();
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getTypeName().equalsIgnoreCase("wifi")&& info[i].isConnected()) {
                        return true;
                    }
                    // 新增加的3g网络判断
                    if (info[i].getTypeName().equalsIgnoreCase("mobile")&& info[i].isConnected()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *  是否有网
     * @param context
     * @return
     */
    public static boolean IsCanConnectNet(Context context) {
        ConnectivityManager cManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cManager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            return true;
        }
        return false;
    }

    /**
     * 打开wifi和GPRS设置
     */
    public static void SetSetting(Activity activity, final int nResultID) {
        try {
            activity.startActivityForResult(new Intent(
                    android.provider.Settings.ACTION_SETTINGS), nResultID);
        } catch (Exception e) {
        }
    }

    public static void   SetWifi(Activity activity, final int requestCode) {
        try {
            activity.startActivityForResult(new Intent(
                    android.provider.Settings.ACTION_WIFI_SETTINGS), requestCode);
        } catch (Exception e) {
        }
    }
    public static void SetWireless(Activity activity, final int requestCode) {
        try {
            activity.startActivityForResult(new Intent(
                            android.provider.Settings.ACTION_WIRELESS_SETTINGS),
                    requestCode);
        } catch (Exception e) {
        }
    }

    /**
     * 是否是手机流量
     *
     * @return
     */
    public static boolean isMobile(Context context) {
        ConnectivityManager cManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        State mobile = cManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
        if (mobile == State.CONNECTED || mobile == State.CONNECTING) {
            return true;
        }
        return false;
    }
}
